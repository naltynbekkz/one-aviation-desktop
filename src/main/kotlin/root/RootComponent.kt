package root

import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.flow.StateFlow

interface RootComponent {

    val refreshToken: StateFlow<String?>
    val routerState: Value<RouterState<RootDestination, Any>>

    fun navigateToMain()
    fun navigateToAuth()

}