package network

import core.CoreSettings
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.apache.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.auth.*
import io.ktor.client.plugins.auth.providers.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.*
import kotlinx.serialization.json.Json

fun provideKtorClient(apiKey: String, appVersion: Int, coreSettings: CoreSettings): HttpClient {

    val json = Json {
        ignoreUnknownKeys = true
        encodeDefaults = true
        prettyPrint = true
        explicitNulls = false
    }

    val tokenClient = getHttpClient(apiKey, appVersion, json)

    return getHttpClient(apiKey, appVersion, json) {
        Auth {
            bearer {
                refreshTokens {
                    val refreshToken = coreSettings.refreshToken.value
                    if (refreshToken != null) {
                        val refreshAccessTokenRequest = TokenRequest(
                            refreshToken,
                            appVersion.toString(),
                        )
                        try {
                            val authResponse = tokenClient.post {
                                url {
                                    path("auth-app/auth/v1/tokens/refresh")
                                }
                                contentType(ContentType.Application.Json)
                                setBody(refreshAccessTokenRequest)
                            }
                            val tokens = authResponse.body<TokenResponse>()
                            coreSettings.setTokens(
                                accessToken = tokens.accessToken,
                                refreshToken = tokens.refreshToken,
                            )
                            BearerTokens(
                                accessToken = tokens.accessToken,
                                refreshToken = tokens.refreshToken,
                            )
                        } catch (e: Exception) {
                            null
                        }
                    } else {
                        null
                    }
                }
                loadTokens {
                    val accessToken = coreSettings.accessToken.value
                    val refreshToken = coreSettings.refreshToken.value
                    if (accessToken != null && refreshToken != null) {
                        BearerTokens(accessToken = accessToken, refreshToken = refreshToken)
                    } else {
                        null
                    }
                }
            }
        }
    }
}

private fun getHttpClient(
    apiKey: String,
    appVersion: Int,
    json: Json,
    block: HttpClientConfig<ApacheEngineConfig>.() -> Unit = { },
): HttpClient {
    return HttpClient(Apache) {

        expectSuccess = true

//        engine {
//            config {
//                trustAllSslInDebug()
//            }
//        }
        install(ContentNegotiation) {
            serialization(ContentType.Application.Json, json)
        }

        install(Logging) {
            level = LogLevel.ALL
        }

        defaultRequest {

            url.protocol = URLProtocol.HTTPS
            host = "dev.zapis.me"

            header("api_key", apiKey)
            header("referrer", "desktop")
            header("desktop_app_version", appVersion.toString())
            header("api_version", "14")

//            header("city_id", runBlocking { cityPreferences.getCity().first().id.toString() })
//            runBlocking { profilePreferences.getFirebaseToken().first() }?.let {
//                header("device_token", it)
//            }
        }

        block()

        install(HttpTimeout) {
            requestTimeoutMillis = 60_000
            connectTimeoutMillis = 60_000
        }

    }
}