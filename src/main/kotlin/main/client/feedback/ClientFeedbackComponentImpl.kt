package main.client.feedback

import com.arkivanov.decompose.ComponentContext

class ClientFeedbackComponentImpl(
    componentContext: ComponentContext,
) : ClientFeedbackComponent, ComponentContext by componentContext