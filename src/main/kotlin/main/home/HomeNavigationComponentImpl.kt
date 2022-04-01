package main.home

import core.CustomComponentContext
import com.arkivanov.decompose.router.Router
import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.router.pop
import core.router
import com.arkivanov.decompose.value.Value
import core.Component

class HomeNavigationComponent(
    customComponentContext: CustomComponentContext,
) : CustomComponentContext by customComponentContext {

    private val router: Router<HomeDestination, CustomComponentContext> = router(
        initialConfiguration = HomeDestination.Home,
        handleBackButton = true,
        setNavigationResultAndNavigateUp = ::handleChildNavigationResult,
        childFactory = { destination, componentContext ->
            when (destination) {
                HomeDestination.Home -> HomeComponent(componentContext)
            }
        }
    )

    private fun handleChildNavigationResult(args: Map<String, Any>) {

    }
    
    val routerState = router.state

    fun navigateToScreen(destination: HomeDestination) {
        router.navigate { list ->
            list + destination
        }
    }

    fun navigateUp() {
        router.pop()
    }

}