package auth.welcome

import com.arkivanov.decompose.ComponentContext

class WelcomeComponentImpl(
    componentContext: ComponentContext,
) : WelcomeComponent, ComponentContext by componentContext