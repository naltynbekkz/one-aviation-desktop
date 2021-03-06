package main.profile.navigation

import com.arkivanov.essenty.parcelable.Parcelable

sealed class ProfileDestination : Parcelable {
    object Profile : ProfileDestination()
    object ChangePassword : ProfileDestination()
    object EditProfile : ProfileDestination()
}