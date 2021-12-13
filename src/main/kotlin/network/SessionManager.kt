package network

import core.CoreSettings
import io.ktor.client.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.auth.*
import io.ktor.client.plugins.auth.providers.*

class SessionManager(
    private val coreSettings: CoreSettings,
    private val httpClient: HttpClient,
) {
    suspend fun login(tokenResponse: TokenResponse) {
        clearToken()
        coreSettings.setTokens(
            accessToken = tokenResponse.accessToken,
            refreshToken = tokenResponse.refreshToken,
        )
    }

    suspend fun logout() {
        clearToken()
        coreSettings.setTokens(null, null)
    }

    private suspend fun clearToken() {
        httpClient[Auth].providers.filterIsInstance<BearerAuthProvider>().first().clearToken()
    }

}