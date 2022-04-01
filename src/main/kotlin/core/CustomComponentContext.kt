package core

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.Router
import com.arkivanov.decompose.router.router
import com.arkivanov.essenty.parcelable.Parcelable
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

interface CustomComponentContext : ComponentContext {

    fun setNavigationResultAndNavigateUp(args: Map<String, Any>)

    val navigationResult: StateFlow<NavigationResult?>

    fun onNavigationResult(args: Map<String, Any>)
}

class DefaultCustomComponentContext(
    componentContext: ComponentContext,
    private val setNavigationResultAndNavigateUp: (args: Map<String, Any>) -> Unit,
) : CustomComponentContext, ComponentContext by componentContext {
    override val navigationResult = MutableStateFlow<NavigationResult?>(null)

    override fun onNavigationResult(args: Map<String, Any>) {
        navigationResult.value = NavigationResult(args)
    }

    override fun setNavigationResultAndNavigateUp(args: Map<String, Any>) {
        setNavigationResultAndNavigateUp.invoke(args)
    }

}

inline fun <reified C : Parcelable, T : Any> CustomComponentContext.router(
    initialConfiguration: C,
    initialBackStack: List<C> = emptyList(),
    key: String = "DefaultRouter",
    handleBackButton: Boolean = false,
    noinline setNavigationResultAndNavigateUp: (args: Map<String, Any>) -> Unit,
    noinline childFactory: (configuration: C, CustomComponentContext) -> T
): Router<C, T> = router(
    initialConfiguration = initialConfiguration,
    initialBackStack = initialBackStack,
    key = key,
    handleBackButton = handleBackButton,
    childFactory = { configuration: C, componentContext: ComponentContext ->
        childFactory(
            configuration,
            DefaultCustomComponentContext(
                componentContext = componentContext,
                setNavigationResultAndNavigateUp = setNavigationResultAndNavigateUp,
            ),
        )
    },
)