package main.help.feedback

import com.arkivanov.essenty.parcelable.Parcelable

sealed class FeedbackDestination : Parcelable {
    object Feedback : FeedbackDestination()
}