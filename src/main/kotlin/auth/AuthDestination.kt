package auth

import com.arkivanov.essenty.parcelable.Parcelable

sealed class AuthDestination : Parcelable {

    object Welcome : AuthDestination()

    object SignIn : AuthDestination()

    object ForgotPassword : AuthDestination()

}