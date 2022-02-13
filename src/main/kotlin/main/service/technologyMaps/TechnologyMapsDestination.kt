package main.service.technologyMaps

import com.arkivanov.essenty.parcelable.Parcelable

sealed class TechnologyMapsDestination : Parcelable {
    object TechnologyMaps : TechnologyMapsDestination()
}