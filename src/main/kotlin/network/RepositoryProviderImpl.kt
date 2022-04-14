package network

import core.CoreSettings
import network.impl.*

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
        TicketsRepositoryImpl(),
        AdminRepositoryImpl(),
    ).onEach {
        it.client = httpClient
        it.coreSettings = coreSettings
    }
}