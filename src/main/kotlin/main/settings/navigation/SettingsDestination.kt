package main.settings.navigation

import com.arkivanov.essenty.parcelable.Parcelable

sealed class SettingsDestination : Parcelable {
    object Settings : SettingsDestination()
    object Actions : SettingsDestination()
    object Billing : SettingsDestination()
    object Deals : SettingsDestination()
    object DiscountSettings : SettingsDestination()
    object FirmSettings : SettingsDestination()
    object LogsSettings : SettingsDestination()
    object PermissionsSettings : SettingsDestination()
    object SmsSettings : SettingsDestination()
    object SourcesSettings : SettingsDestination()
    object WorkplacesSettings : SettingsDestination()
}