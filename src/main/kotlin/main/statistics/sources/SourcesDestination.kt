package main.statistics.sources

import com.arkivanov.essenty.parcelable.Parcelable

sealed class SourcesDestination : Parcelable {
    object Sources : SourcesDestination()
}