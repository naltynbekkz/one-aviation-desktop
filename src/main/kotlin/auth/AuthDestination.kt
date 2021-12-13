package auth

import com.arkivanov.essenty.parcelable.Parcelable

sealed class AuthDestination : Parcelable {

    object SignIn : AuthDestination()

    object SignUp : AuthDestination()

}