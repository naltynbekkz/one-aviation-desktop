package network

import core.CoreSettings
import network.impl.AuthRepositoryImpl
import network.impl.FlightsRepositoryImpl
import network.impl.PlanesRepositoryImpl
import network.impl.ProfileRepositoryImpl

class RepositoryProviderImpl(
    apiKey: String,
    appVersion: Int,
    coreSettings: CoreSettings,
) : RepositoryProvider {

    private val httpClient = provideKtorClient(apiKey, appVersion, coreSettings)

    override val repositories = listOf(
        AuthRepositoryImpl(),
        ProfileRepositoryImpl(),
        PlanesRepositoryImpl(),
        FlightsRepositoryImpl(),
    ).onEach {
        it.client = httpClient
        it.coreSettings = coreSettings
    }
}