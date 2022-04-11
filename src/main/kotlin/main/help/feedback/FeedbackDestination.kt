package main.help.feedback

import com.arkivanov.essenty.parcelable.Parcelable
import main.help.feedback.model.Feedback

sealed class FeedbackDestination : Parcelable {
    object Feedbacks : FeedbackDestination()
    object NewFeedback : FeedbackDestination()
    class DeleteFeedback(val feedback: Feedback) : FeedbackDestination()
}