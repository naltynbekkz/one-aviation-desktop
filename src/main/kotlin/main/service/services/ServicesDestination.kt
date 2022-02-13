package main.service.services

import com.arkivanov.essenty.parcelable.Parcelable

sealed class ServicesDestination : Parcelable {
    object Services : ServicesDestination()
}