package main.home

import com.arkivanov.essenty.parcelable.Parcelable

sealed class HomeDestination : Parcelable {
    object Home : HomeDestination()
}