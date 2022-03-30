package network

import core.CoreSettings
import io.ktor.client.*
import io.ktor.client.engine.apache.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.*
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json

fun provideKtorClient(apiKey: String, appVersion: Int, coreSettings: CoreSettings): HttpClient {

    val json = Json {
        ignoreUnknownKeys = true
        encodeDefaults = true
        prettyPrint = true
        explicitNulls = false
    }

    return getHttpClient(apiKey, appVersion, json, coreSettings)
}

private fun getHttpClient(
    apiKey: String,
    appVersion: Int,
    json: Json,
    coreSettings: CoreSettings,
    block: HttpClientConfig<ApacheEngineConfig>.() -> Unit = { },
): HttpClient {
    return HttpClient(Apache) {

        expectSuccess = true

        install(ContentNegotiation) {
            serialization(ContentType.Application.Json, json)
        }

        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.ALL
        }

        defaultRequest {

            url.protocol = URLProtocol.HTTP
            host = "192.168.183.253:8080"

            header("api_key", apiKey)
            header("referrer", "desktop")
            header("desktop_app_version", appVersion.toString())
            header("api_version", "14")

            val token = runBlocking { coreSettings.refreshToken.first() }
            if (!token.isNullOrEmpty()) {
                header("Authorization", "Bearer $token")
            }
        }

        block()

        install(HttpTimeout) {
            requestTimeoutMillis = 60_000
            connectTimeoutMillis = 60_000
        }

    }
}