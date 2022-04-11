package main.help.feedback.newfeedback

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import main.help.feedback.feedBacksViewModel
import main.help.feedback.model.Feedback

@OptIn(ExperimentalComposeUiApi::class, ExperimentalFoundationApi::class, ExperimentalUnitApi::class)
@Composable
fun NewFeedbackScreen(
    component: NewFeedbackComponent,
    navigateUp: () -> Unit
) {

    var name: String by remember { mutableStateOf("") }
    var feedback: String by remember { mutableStateOf("") }
    var rating: String by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Create a feedback")
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
                text = "Create a new feedback",
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold
            )
            OutlinedTextField(value = name,
                onValueChange = { name = it },
                modifier = Modifier.wrapContentWidth().padding(bottom = 4.dp),
                label = { Text("Name") })

            OutlinedTextField(value = feedback,
                onValueChange = { feedback = it },
                modifier = Modifier.wrapContentWidth().padding(bottom = 4.dp),
                label = { Text("Feedback") })
            OutlinedTextField(value = rating,
                onValueChange = { rating = it },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.wrapContentWidth(),
                label = { Text("Rating") })

            Button(modifier = Modifier.padding(top = 8.dp), onClick = {
                feedBacksViewModel.addFeedback(
                    Feedback(
                        name = name,
                        feedback = feedback,
                        rating = rating.toInt()
                    )
                )
                navigateUp()
            }) {
                Text("Create")
            }
        }

    }
}