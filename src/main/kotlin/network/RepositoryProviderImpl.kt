package network

import core.CoreSettings
import network.impl.AuthRepositoryImpl

class RepositoryProviderImpl(
    apiKey: String,
    appVersion: Int,
    coreSettings: CoreSettings,
) : RepositoryProvider {

    private val httpClient = provideKtorClient(apiKey, appVersion, coreSettings)
    private val sessionManager = SessionManager(coreSettings, httpClient)

    override val repositories = listOf<BaseRepository>(
        AuthRepositoryImpl()
    ).onEach {
        it.client = httpClient
        it.sessionManager = sessionManager
    }
}