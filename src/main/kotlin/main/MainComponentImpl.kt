package main

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.Router
import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.router.pop
import com.arkivanov.decompose.router.router
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import core.Component
import development.InDevelopmentComponent
import main.home.HomeComponentImpl
import main.profile.ProfileComponentImpl
import network.RepositoryProvider
import settings.SettingsProvider
import settings.get

class MainComponentImpl(
    private val repositoryProvider: RepositoryProvider,
    private val settingsProvider: SettingsProvider,
    componentContext: ComponentContext,
) : MainComponent, ComponentContext by componentContext {

    override val destinations = MutableValue(MainDestination.screens)

    private val router: Router<MainDestination, Component> = router(
        initialConfiguration = MainDestination.Home,
        handleBackButton = true,
        childFactory = ::resolveChild
    )

    override val routerState: Value<RouterState<MainDestination, Component>> = router.state

    private fun resolveChild(mainDestination: MainDestination, componentContext: ComponentContext): Component =
        when (mainDestination) {
            MainDestination.Home -> HomeComponentImpl(componentContext, settingsProvider.get())
            MainDestination.Profile -> ProfileComponentImpl(componentContext, settingsProvider.get())
            else -> InDevelopmentComponent(componentContext)
        }

    override fun navigateToScreen(mainDestination: MainDestination) {
        router.navigate { list ->
            list.filter { it != mainDestination } + mainDestination
        }
    }

    override fun navigateBack() {
        router.pop()
    }

}