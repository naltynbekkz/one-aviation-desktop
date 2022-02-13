package main.client.loyalties

import com.arkivanov.decompose.ComponentContext

class LoyaltiesComponentImpl(
    componentContext: ComponentContext,
) : LoyaltiesComponent, ComponentContext by componentContext