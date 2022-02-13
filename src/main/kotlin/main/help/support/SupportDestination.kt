package main.help.support

import com.arkivanov.essenty.parcelable.Parcelable

sealed class SupportDestination : Parcelable {
    object Support : SupportDestination()
}