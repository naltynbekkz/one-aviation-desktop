package core

import kotlinx.coroutines.flow.StateFlow

interface CoreSettings {

    val refreshToken: StateFlow<String?>
    fun setRefreshToken(value: String?)

    val accessToken: StateFlow<String?>
    fun setAccessToken(value: String?)

    fun setTokens(accessToken: String?, refreshToken: String?)

}