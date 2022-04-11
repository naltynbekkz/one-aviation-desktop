package main.help.feedback

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.compose.jetbrains.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import core.slideFade
import main.help.feedback.deletefeedback.DeleteFeedbackComponent
import main.help.feedback.deletefeedback.DeleteFeedbackScreen
import main.help.feedback.newfeedback.NewFeedbackComponent
import main.help.feedback.newfeedback.NewFeedbackScreen

val feedBacksViewModel = FeedBacksViewModel()

@OptIn(ExperimentalDecomposeApi::class)
@Composable
fun FeedbackNavigation(component: FeedbackNavigationComponent) {

    val routerState by component.routerState.subscribeAsState()
    Box(modifier = Modifier.fillMaxSize()) {
        Children(routerState = routerState, animation = slideFade()) {
            when (val child = it.instance) {
                is FeedbackComponent -> FeedbackScreen(
                    child,
                    navigateToNewFeedback = {
                        component.navigateToScreen(FeedbackDestination.NewFeedback)
                    },
                    navigateToDeleteFeedback = {
                        component.navigateToScreen(FeedbackDestination.DeleteFeedback(it))
                    })
                is NewFeedbackComponent -> NewFeedbackScreen(child, navigateUp = { component.navigateUp() })
                is DeleteFeedbackComponent -> DeleteFeedbackScreen(
                    component = child,
                    navigateUp = {
                        component.navigateUp()
                    },
                    feedbackExist = feedBacksViewModel.deleteFeedback
                )
            }
        }
    }
}