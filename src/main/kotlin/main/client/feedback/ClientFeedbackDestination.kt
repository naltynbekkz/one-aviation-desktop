package main.client.feedback

import com.arkivanov.essenty.parcelable.Parcelable

sealed class ClientFeedbackDestination : Parcelable {
    object ClientFeedback : ClientFeedbackDestination()
}