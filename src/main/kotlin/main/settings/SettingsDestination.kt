package main.settings

import com.arkivanov.essenty.parcelable.Parcelable

sealed class SettingsDestination : Parcelable {
    object Settings : SettingsDestination()
}