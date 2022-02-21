package core

import kotlinx.coroutines.flow.StateFlow

interface CoreSettings {

    val refreshToken: StateFlow<String?>
    fun setRefreshToken(value: String?)

}