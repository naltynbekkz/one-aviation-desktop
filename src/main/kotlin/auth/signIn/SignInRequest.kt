package auth.signIn

import kotlinx.serialization.Serializable

@Serializable
data class SignInRequest(
    val phone: String,
    val password: String,
    val appVersion: String,
    val clientApp: String = "ANDROID_CLIENT",
    val deviceName: String = "UNKNOWN",
    val deviceOS: String = "desktop",
)