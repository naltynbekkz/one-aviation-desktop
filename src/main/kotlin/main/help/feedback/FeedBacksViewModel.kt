package main.help.feedback

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import main.help.feedback.model.Feedback

class FeedBacksViewModel {
    var feedbacks by mutableStateOf(
        listOf(
            Feedback("Monica", "Good", 5),
            Feedback("John", "Fine", 4)
        )
    )

    var deleteFeedback: Feedback = Feedback("", "", 0)

    fun addFeedback(feedback: Feedback) {
        feedbacks = feedbacks + listOf(feedback)
    }

    fun removeFeedback(feedback: Feedback) {
        feedbacks = feedbacks.toMutableList().also {
            it.remove(feedback)
        }
    }
}