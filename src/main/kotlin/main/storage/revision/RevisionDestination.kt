package main.storage.revision

import com.arkivanov.essenty.parcelable.Parcelable

sealed class RevisionDestination : Parcelable {
    object Revision : RevisionDestination()
}