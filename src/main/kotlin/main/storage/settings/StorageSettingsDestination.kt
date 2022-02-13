package main.storage.settings

import com.arkivanov.essenty.parcelable.Parcelable

sealed class StorageSettingsDestination : Parcelable {
    object StorageSettings : StorageSettingsDestination()
}