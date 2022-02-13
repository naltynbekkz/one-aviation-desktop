package main.profile

import com.arkivanov.essenty.parcelable.Parcelable

sealed class ProfileDestination : Parcelable {
    object Profile : ProfileDestination()
}