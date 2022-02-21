package network

import core.CoreSettings
import network.impl.AuthRepositoryImpl
import network.impl.ProfileRepositoryImpl

class RepositoryProviderImpl(
    apiKey: String,
    appVersion: Int,
    coreSettings: CoreSettings,
) : RepositoryProvider {

    private val httpClient = provideKtorClient(apiKey, appVersion, coreSettings)

    override val repositories = listOf<BaseRepository>(
        AuthRepositoryImpl(),
        ProfileRepositoryImpl(),
    ).onEach {
        it.client = httpClient
        it.coreSettings = coreSettings
    }
}