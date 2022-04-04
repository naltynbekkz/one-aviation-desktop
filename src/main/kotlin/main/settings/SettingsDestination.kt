package main.settings

import com.arkivanov.essenty.parcelable.Parcelable

sealed class SettingsDestination : Parcelable {
    object Settings : SettingsDestination()
    object Airplane : SettingsDestination()
    object Billing : SettingsDestination()
    object Sms : SettingsDestination()
    object Rights : SettingsDestination()
}