package main.settings.sms

import com.arkivanov.decompose.ComponentContext
import main.settings.billing.BillingComponent

class SmsComponentImpl(
    componentContext: ComponentContext,
) : SmsComponent, ComponentContext by componentContext {

}