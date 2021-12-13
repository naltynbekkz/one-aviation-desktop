package root

import com.arkivanov.essenty.parcelable.Parcelable

sealed class RootDestination : Parcelable {

    object Auth : RootDestination()

    object Main : RootDestination()

}