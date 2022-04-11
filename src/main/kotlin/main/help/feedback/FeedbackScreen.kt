package main.help.feedback

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import main.help.feedback.model.Feedback

@Composable
fun FeedbackScreen(
    component: FeedbackComponent,
    navigateToNewFeedback: () -> Unit,
    navigateToDeleteFeedback: (Feedback) -> Unit
) {
    val feedbacks = remember {
        feedBacksViewModel.feedbacks
    }
    Scaffold(floatingActionButton = {
        FloatingActionButton(onClick = { navigateToNewFeedback() }) {
            Icon(imageVector = Icons.Default.Add, contentDescription = null, tint = Color.White)
        }
    }) {

    }

    LazyColumn(contentPadding = PaddingValues(80.dp)) {
        item {
            Header(text = "Feedbacks for now")
        }
        item {
            Surface(modifier = Modifier.fillMaxWidth().requiredHeight(10.dp)) { }
        }
        item {
            Card(
                modifier = Modifier.fillMaxWidth().requiredHeight(40.dp),
                shape = RectangleShape,
                backgroundColor = MaterialTheme.colors.primary.copy(0.1f),
                elevation = 0.dp
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(8.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier.weight(1f),
                        text = "Name",
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        modifier = Modifier.weight(1f),
                        text = "Feedback",
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        modifier = Modifier.weight(1f),
                        text = "Rating",
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(text = "Remove it", fontWeight = FontWeight.SemiBold)
                }
            }
        }
        items(feedbacks) { feedback ->
            FeedbackListItem(feedback = feedback, navigateToDeleteFeedback)
        }
    }
}

@Composable
fun FeedbackListItem(
    feedback: Feedback,
    navigateToDeleteFeedback: (Feedback) -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth().padding(8.dp)
    ) {
        Text(modifier = Modifier.weight(1f), text = feedback.name, textAlign = TextAlign.Center)
        Text(
            modifier = Modifier.weight(1f),
            text = feedback.feedback,
            style = MaterialTheme.typography.h6,
            textAlign = TextAlign.Center
        )
        Text(
            modifier = Modifier.weight(1f),
            text = feedback.rating.toString(),
            style = MaterialTheme.typography.body2,
            color = Color.Black.copy(.5f),
            textAlign = TextAlign.Center
        )
        Button(
            onClick = {
                navigateToDeleteFeedback(feedback)
                feedBacksViewModel.deleteFeedback = feedback
            }
        ) {
            Text(text = "Delete")
        }
    }
    Divider(color = Color.Gray.copy(alpha = 0.4f), thickness = 1.dp)
}

@Composable
fun Header(
    text: String,
    modifier: Modifier = Modifier
) {
    Surface(
        color = MaterialTheme.colors.onSurface.copy(.1f),
        contentColor = MaterialTheme.colors.primary,
        modifier = modifier.semantics { heading() }
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.subtitle2,
            modifier = modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp)
        )
    }
}