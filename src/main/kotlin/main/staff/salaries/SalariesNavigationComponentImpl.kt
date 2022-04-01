package main.staff.salaries

import core.CustomComponentContext
import com.arkivanov.decompose.router.Router
import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.router.pop
import core.router
import com.arkivanov.decompose.value.Value
import core.Component

class SalariesNavigationComponent(
    customComponentContext: CustomComponentContext,
) : CustomComponentContext by customComponentContext {

    private val router: Router<SalariesDestination, CustomComponentContext> = router(
        initialConfiguration = SalariesDestination.Salaries,
        handleBackButton = true,
        setNavigationResultAndNavigateUp = ::handleChildNavigationResult,
        childFactory = { destination, componentContext ->
            when (destination) {
                SalariesDestination.Salaries -> SalariesComponent(componentContext)
            }
        }
    )

    private fun handleChildNavigationResult(args: Map<String, Any>) {

    }
    
    val routerState = router.state

    fun navigateToScreen(destination: SalariesDestination) {
        router.navigate { list ->
            list + destination
        }
    }

    fun navigateUp() {
        router.pop()
    }

}