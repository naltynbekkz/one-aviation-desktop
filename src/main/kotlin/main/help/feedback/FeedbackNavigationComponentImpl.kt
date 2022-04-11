package main.help.feedback

import com.arkivanov.decompose.router.Router
import com.arkivanov.decompose.router.pop
import core.CustomComponentContext
import core.router
import main.help.feedback.deletefeedback.DeleteFeedbackComponent
import main.help.feedback.newfeedback.NewFeedbackComponent

class FeedbackNavigationComponent(
    customComponentContext: CustomComponentContext,
) : CustomComponentContext by customComponentContext {

    private val router: Router<FeedbackDestination, CustomComponentContext> = router(
        initialConfiguration = FeedbackDestination.Feedbacks,
        handleBackButton = true,
        setNavigationResultAndNavigateUp = ::handleChildNavigationResult,
        childFactory = { destination, componentContext ->
            when (destination) {
                FeedbackDestination.Feedbacks -> FeedbackComponent(componentContext)
                FeedbackDestination.NewFeedback -> NewFeedbackComponent(componentContext)
                FeedbackDestination.DeleteFeedback(feedBacksViewModel.deleteFeedback) -> DeleteFeedbackComponent(
                    componentContext
                )
                else -> DeleteFeedbackComponent(componentContext)
            }
        }
    )

    private fun handleChildNavigationResult(args: Map<String, Any>) {

    }

    val routerState = router.state

    fun navigateToScreen(destination: FeedbackDestination) {
        router.navigate { list ->
            list + destination
        }
    }

    fun navigateUp() {
        router.pop()
    }

}