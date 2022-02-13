package main.storage.storageReport

import com.arkivanov.essenty.parcelable.Parcelable

sealed class StorageReportDestination : Parcelable {
    object StorageReport : StorageReportDestination()
}