package main.settings.billing

import com.arkivanov.decompose.ComponentContext

class BillingComponentImpl(
    componentContext: ComponentContext,
) : BillingComponent, ComponentContext by componentContext