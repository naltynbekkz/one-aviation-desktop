package auth.signIn

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import core.LoadingGreenButton
import network.ResponseState

@Composable
fun SignInScreen(
    signInComponent: SignInComponent,
    navigateToForgotPassword: () -> Unit,
    navigateUp: () -> Unit,
) {

    val responseState by signInComponent.signIn.response.collectAsState()

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

        var username: String by remember { mutableStateOf("") }
        var password: String by remember { mutableStateOf("") }

        Column(
            modifier = Modifier
                .wrapContentSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "Login",
                modifier = Modifier.padding(16.dp),
                fontSize = 24.sp
            )
            Text(
                text = "Enter your username and password",
                modifier = Modifier.padding(16.dp),
                fontSize = 16.sp
            )

            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 4.dp)
                    .wrapContentWidth(),
                label = { Text("Username") }
            )
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 4.dp)
                    .wrapContentWidth(),
                label = { Text("Password") }
            )

            Text(
                text = "Forgot password?",
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .clickable {
                        navigateToForgotPassword()
                    },
            )

            LoadingGreenButton(
                text = "Login",
                isLoading = responseState is ResponseState.Loading,
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .wrapContentWidth()
                    .wrapContentHeight(),
            ) {
                signInComponent.signIn.initialFetch(SignInRequest(username, password))
            }

            Box(
                modifier = Modifier
                    .wrapContentWidth()
                    .padding(bottom = 16.dp),
                contentAlignment = Alignment.Center
            ) {
                ClickableText(
                    text = buildAnnotatedString {
                        withStyle(style = SpanStyle(color = Color.Blue)) {
                            AnnotatedString("Already have an account?")
                        }
                        append(" ")
                        withStyle(style = SpanStyle(color = Color.Blue)) {
                            AnnotatedString("Sign in")
                        }
                    },
                    onClick = {

                    }
                )
            }
        }
    }
}