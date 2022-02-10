package main.profile

import com.arkivanov.essenty.parcelable.Parcelable

sealed class ProfileDestination(val title: String) : Parcelable {
    object Profile : ProfileDestination("Profile")
    object ChangePassword : ProfileDestination("Change Password")

    companion object {
        val screens = listOf(
            Profile,
            ChangePassword,
        )
    }
}