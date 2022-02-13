package main.client.smsMailing

import com.arkivanov.decompose.ComponentContext

class SmsMailingComponentImpl(
    componentContext: ComponentContext,
) : SmsMailingComponent, ComponentContext by componentContext