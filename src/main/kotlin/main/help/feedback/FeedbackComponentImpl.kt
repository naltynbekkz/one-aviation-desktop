package main.help.feedback

import com.arkivanov.decompose.ComponentContext

class FeedbackComponentImpl(
    componentContext: ComponentContext,
) : FeedbackComponent, ComponentContext by componentContext