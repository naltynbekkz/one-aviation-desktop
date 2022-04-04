package main.settings.sms

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import theme.green

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SmsScreen(
    smsComponent: SmsComponent,
    navigateUp: () -> Unit
) {

    var smsSuccessful: String by remember { mutableStateOf("You have bought a ticket!\nDate: 28.03 11:08\nNumber of phone: +77770235648") }
    var smsNotification: String by remember { mutableStateOf("Notification about flight\nDate: 12.05 12:30\nNumber of phone: +77775631478") }
    var smsCancel: String by remember { mutableStateOf("Flight is cancelled.\nDate: 03.11 14.25\nNumber of phone: +77085129863") }

    val isCheckedSmsSuccessful = remember { mutableStateOf(false) }
    val isCheckedSmsNotification = remember { mutableStateOf(false) }
    val isCheckedSmsCancelled = remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Sms settings")
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
        LazyVerticalGrid(
            modifier = Modifier.fillMaxWidth(),
            cells = GridCells.Adaptive(600.dp),
        ) {

            items(1) {
                Card(
                    modifier = Modifier
                        .padding(24.dp)
                        .requiredHeight(640.dp)
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    elevation = 8.dp,
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.Start
                    ) {

                        Text(
                            modifier = Modifier.padding(start = 16.dp, top = 16.dp),
                            text = "Sms settings",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colors.primary
                        )
                        Text(
                            text = "Sms about successful booking",
                            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 18.dp),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                        OutlinedTextField(value = smsSuccessful,
                            onValueChange = { smsSuccessful = it },
                            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 8.dp).fillMaxWidth(),
                            label = { Text("Successful booking sms") })

                        Row(
                            modifier = Modifier.requiredHeight(26.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                modifier = Modifier.padding(start = 16.dp),
                                text = "Cost: 12 ₸/sms",
                                fontSize = 12.sp,
                                fontStyle = FontStyle.Italic,
                                color = Color.Gray
                            )
                            Checkbox(
                                checked = isCheckedSmsSuccessful.value,
                                onCheckedChange = {
                                    isCheckedSmsSuccessful.value = it
                                },
                                modifier = Modifier.wrapContentSize()
                            )
                            Text(text = "Send")
                        }
                        Text(
                            text = "Sms notification about flight",
                            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 18.dp),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold
                        )

                        OutlinedTextField(value = smsNotification,
                            onValueChange = { smsNotification = it },
                            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 8.dp).fillMaxWidth(),
                            label = { Text("Sms notification") })

                        Row(
                            modifier = Modifier.requiredHeight(26.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                modifier = Modifier.padding(start = 16.dp),
                                text = "Cost: 12 ₸/sms",
                                fontSize = 12.sp,
                                fontStyle = FontStyle.Italic,
                                color = Color.Gray
                            )
                            Checkbox(
                                checked = isCheckedSmsNotification.value,
                                onCheckedChange = {
                                    isCheckedSmsNotification.value = it
                                },
                                modifier = Modifier.wrapContentSize()
                            )
                            Text(text = "Send")
                        }
                        Text(
                            text = "Sms about cancel of flight",
                            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 18.dp),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                        OutlinedTextField(value = smsCancel,
                            onValueChange = { smsCancel = it },
                            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 8.dp).fillMaxWidth(),
                            label = { Text("Cancel of flight sms") })

                        Row(
                            modifier = Modifier.requiredHeight(26.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                modifier = Modifier.padding(start = 16.dp),
                                text = "Cost: 12 ₸/sms",
                                fontSize = 12.sp,
                                fontStyle = FontStyle.Italic,
                                color = Color.Gray
                            )
                            Checkbox(
                                checked = isCheckedSmsCancelled.value,
                                onCheckedChange = {
                                    isCheckedSmsCancelled.value = it
                                },
                                modifier = Modifier.wrapContentSize()
                            )
                            Text(text = "Send")
                        }
                        Button(
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp),
                            colors = ButtonDefaults.buttonColors(green),
                            onClick = {
                                navigateUp.invoke()
                            }) {
                            Text(text = "Save", color = Color.White)
                        }
                    }
                }
            }
        }
    }
}
