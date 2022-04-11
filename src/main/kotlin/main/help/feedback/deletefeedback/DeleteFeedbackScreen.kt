package main.help.feedback.deletefeedback

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import main.help.feedback.feedBacksViewModel
import main.help.feedback.model.Feedback

@Composable
fun DeleteFeedbackScreen(
    component: DeleteFeedbackComponent,
    navigateUp: () -> Unit,
    feedbackExist: Feedback
) {
    var name: String by remember { mutableStateOf(feedbackExist.name) }
    var feedback: String by remember { mutableStateOf(feedbackExist.feedback) }
    var rating: String by remember { mutableStateOf(feedbackExist.rating.toString()) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Delete a feedback")
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navigateUp()
                    }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "back button",
                            tint = MaterialTheme.colors.primary,
                        )
                    }
                },
                backgroundColor = MaterialTheme.colors.background,
            )
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.padding(bottom = 8.dp),
                text = "Are you sure to delete this feedback?",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold
            )
            OutlinedTextField(value = name,
                onValueChange = { name = it },
                enabled = false,
                modifier = Modifier.wrapContentWidth().padding(bottom = 4.dp),
                label = { Text("Name") })

            OutlinedTextField(value = feedback,
                onValueChange = { feedback = it },
                enabled = false,
                modifier = Modifier.wrapContentWidth().padding(bottom = 4.dp),
                label = { Text("Feedback") })
            OutlinedTextField(value = rating,
                onValueChange = { rating = it },
                enabled = false,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.wrapContentWidth(),
                label = { Text("Rating") })

            Row(modifier = Modifier.padding(top = 8.dp)) {
                Button(modifier = Modifier.padding(horizontal = 4.dp), onClick = {
                    feedBacksViewModel.removeFeedback(
                        Feedback(
                            name = feedbackExist.name,
                            feedback = feedbackExist.feedback,
                            rating = feedbackExist.rating
                        )
                    )
                    navigateUp()
                }) {
                    Text("Yes")
                }
                Button(modifier = Modifier.padding(horizontal = 4.dp), onClick = {
                    navigateUp()
                }) {
                    Text("No")
                }
            }
        }
    }
}