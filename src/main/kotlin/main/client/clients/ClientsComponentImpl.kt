package main.client.clients

import com.arkivanov.decompose.ComponentContext

class ClientsComponentImpl(
    componentContext: ComponentContext,
) : ClientsComponent, ComponentContext by componentContext