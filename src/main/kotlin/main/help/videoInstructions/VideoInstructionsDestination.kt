package main.help.videoInstructions

import com.arkivanov.essenty.parcelable.Parcelable

sealed class VideoInstructionsDestination : Parcelable {
    object VideoInstructions : VideoInstructionsDestination()
}