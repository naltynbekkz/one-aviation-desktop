package auth

import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.value.Value
import core.Component

interface AuthComponent : Component {
    val routerState: Value<RouterState<AuthDestination, Component>>

    fun navigateToScreen(authDestination: AuthDestination)
    fun navigateUp()
}