package main.profile.profile

import core.Component
import kotlinx.coroutines.flow.StateFlow

interface ProfileComponent : Component {
    val refreshToken: StateFlow<String?>

    fun setRefreshToken(value: String?)
}