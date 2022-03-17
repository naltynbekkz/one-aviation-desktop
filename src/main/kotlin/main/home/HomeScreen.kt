package main.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import theme.gray500
import theme.gray900
import theme.green

@OptIn(ExperimentalComposeUiApi::class, ExperimentalFoundationApi::class, ExperimentalUnitApi::class)
@Composable
fun HomeScreen(component: HomeComponent) {

    var note: String by remember { mutableStateOf("") }

    Column {
        Card(
            modifier = Modifier
                .padding(24.dp)
                .requiredHeight(78.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(4.dp),
            elevation = 0.dp,
            backgroundColor = MaterialTheme.colors.primary.copy(alpha = 0.1f)
        ) {

            Text(
                text = "Welcome back, Martin Luther",
                modifier = Modifier.padding(12.dp).wrapContentHeight().fillMaxWidth(),
                fontSize = 24.sp,
                textAlign = TextAlign.Start
            )

            Text(
                text = "Your subscription is prolonged",
                modifier = Modifier.padding(12.dp).wrapContentHeight().fillMaxWidth(),
                fontSize = 20.sp,
                textAlign = TextAlign.End,
                fontFamily = FontFamily.Monospace
            )
        }

        LazyVerticalGrid(
            modifier = Modifier.fillMaxWidth(),
            cells = GridCells.Adaptive(600.dp),
        ) {

            items(2) { it ->
                Card(
                    modifier = Modifier
                        .padding(24.dp)
                        .requiredHeight(240.dp)
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    elevation = 8.dp,
                ) {

                    if (it == 0) {
                        Column {
                            Text(
                                text = "Booking for today",
                                modifier = Modifier.padding(18.dp).fillMaxWidth(),
                                textAlign = TextAlign.Start,
                                fontSize = 20.sp
                            )

                            LazyVerticalGrid(
                                modifier = Modifier.fillMaxSize(),
                                cells = GridCells.Adaptive(300.dp)
                            ) {

                                items(4) { itemCount ->
                                    if (itemCount == 0) {
                                        Card(
                                            modifier = Modifier
                                                .padding(12.dp)
                                                .requiredHeight(62.dp)
                                                .fillMaxWidth(),
                                            shape = RoundedCornerShape(4.dp),
                                            elevation = 4.dp,
                                        ) {
                                            Column(modifier = Modifier.fillMaxSize()) {
                                                Text(
                                                    text = "Offline bookings",
                                                    modifier = Modifier.padding(horizontal = 12.dp).fillMaxWidth(),
                                                    fontSize = 10.sp,
                                                    textAlign = TextAlign.Start
                                                )
                                                Text(
                                                    text = "0",
                                                    fontWeight = FontWeight.SemiBold,
                                                    modifier = Modifier.padding(horizontal = 12.dp).fillMaxWidth(),
                                                    fontSize = 16.sp
                                                )
                                            }
                                        }
                                    } else if (itemCount == 1) {
                                        Card(
                                            modifier = Modifier
                                                .padding(12.dp)
                                                .requiredHeight(62.dp)
                                                .fillMaxWidth(),
                                            shape = RoundedCornerShape(4.dp),
                                            elevation = 4.dp,
                                        ) {
                                            Column(modifier = Modifier.fillMaxSize()) {
                                                Text(
                                                    text = "Online bookings",
                                                    modifier = Modifier.padding(horizontal = 12.dp).fillMaxWidth(),
                                                    fontSize = 10.sp,
                                                    textAlign = TextAlign.Start
                                                )
                                                Text(
                                                    text = "1",
                                                    fontWeight = FontWeight.Bold,
                                                    modifier = Modifier.padding(horizontal = 12.dp).fillMaxWidth(),
                                                    fontSize = 16.sp
                                                )
                                            }
                                        }
                                    } else if (itemCount == 2) {
                                        Card(
                                            modifier = Modifier
                                                .padding(12.dp)
                                                .requiredHeight(62.dp)
                                                .fillMaxWidth(),
                                            shape = RoundedCornerShape(4.dp),
                                            elevation = 4.dp,
                                        ) {
                                            Column(modifier = Modifier.fillMaxSize()) {
                                                Text(
                                                    text = "Served",
                                                    modifier = Modifier.padding(horizontal = 12.dp).fillMaxWidth(),
                                                    fontSize = 10.sp,
                                                    textAlign = TextAlign.Start
                                                )
                                                Text(
                                                    text = "13",
                                                    fontWeight = FontWeight.Bold,
                                                    modifier = Modifier.padding(horizontal = 12.dp).fillMaxWidth(),
                                                    fontSize = 16.sp
                                                )
                                            }
                                        }
                                    } else if (itemCount == 3) {
                                        Card(
                                            modifier = Modifier
                                                .padding(12.dp)
                                                .requiredHeight(62.dp)
                                                .fillMaxWidth(),
                                            shape = RoundedCornerShape(4.dp),
                                            elevation = 4.dp,
                                        ) {
                                            Column(modifier = Modifier.fillMaxSize()) {
                                                Text(
                                                    text = "New clients",
                                                    modifier = Modifier.padding(horizontal = 12.dp).fillMaxWidth(),
                                                    fontSize = 10.sp,
                                                    textAlign = TextAlign.Start
                                                )
                                                Text(
                                                    text = "25",
                                                    fontWeight = FontWeight.Bold,
                                                    modifier = Modifier.padding(horizontal = 12.dp).fillMaxWidth(),
                                                    fontSize = 16.sp
                                                )
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        Column {
                            Text(
                                text = "Notes",
                                modifier = Modifier.padding(18.dp).fillMaxWidth(),
                                textAlign = TextAlign.Start,
                                fontSize = 20.sp
                            )

                            Card(
                                modifier = Modifier
                                    .padding(12.dp)
                                    .requiredHeight(112.dp)
                                    .fillMaxWidth(),
                                shape = RoundedCornerShape(4.dp),
                                elevation = 4.dp,
                            ) {
                                Column {
                                    Text(
                                        text = "Enter your note:",
                                        modifier = Modifier.padding(horizontal = 12.dp).fillMaxWidth(),
                                        fontSize = 14.sp
                                    )

                                    OutlinedTextField(
                                        value = note,
                                        onValueChange = { note = it },
                                        modifier = Modifier
                                            .padding(horizontal = 12.dp, vertical = 4.dp)
                                            .wrapContentWidth(),
                                        label = { Text("Write your note") }
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
        Card(
            modifier = Modifier.padding(24.dp).requiredHeight(64.dp).fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            elevation = 4.dp
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Learn how to increase customer flow",
                    modifier = Modifier.padding(start = 12.dp, top = 12.dp, bottom = 12.dp, end = 86.dp)
                        .wrapContentSize(),
                    fontSize = 18.sp
                )
                Button(
                    modifier = Modifier.padding(12.dp).requiredWidth(300.dp),
                    onClick = {},
                    border = BorderStroke(0.5.dp, Color.Black),
                    colors = buttonColors(green, Color.White)
                ) {
                    Text(
                        text = "Learn details",
                        modifier = Modifier.padding(vertical = 4.dp)
                    )
                }
            }
        }
        LazyVerticalGrid(
            modifier = Modifier.fillMaxWidth(),
            cells = GridCells.Adaptive(600.dp)
        ) {
            items(2) { itemCount ->
                Card(
                    modifier = Modifier
                        .padding(24.dp)
                        .requiredHeight(200.dp)
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    elevation = 8.dp
                ) {
                    if (itemCount == 0) {
                        Column {
                            Row(
                                modifier = Modifier.padding(start = 18.dp, end = 18.dp, top = 18.dp).fillMaxWidth()
                            ) {
                                Text(
                                    text = "Updates",
                                    fontSize = 20.sp
                                )
                                Text(
                                    text = "Show all >",
                                    modifier = Modifier.fillMaxWidth().padding(end = 16.dp),
                                    fontSize = 12.sp,
                                    fontStyle = FontStyle.Italic,
                                    textAlign = TextAlign.End,
                                    textDecoration = TextDecoration.Underline,
                                    color = Color.Blue
                                )
                            }

                            Row(
                                modifier = Modifier.padding(start = 18.dp, end = 18.dp, top = 8.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "v 1.02.1",
                                    fontSize = 12.sp
                                )
                                Card(
                                    modifier = Modifier.padding(start = 12.dp, top = 8.dp).requiredWidth(40.dp)
                                        .requiredHeight(28.dp),
                                    shape = RoundedCornerShape(2.dp),
                                    backgroundColor = green
                                ) {
                                    Text(
                                        text = "NEW",
                                        modifier = Modifier.fillMaxSize(),
                                        fontSize = 12.sp,
                                        textAlign = TextAlign.Center,
                                        color = Color.White
                                    )
                                }
                                Text(
                                    text = "22.12.2021, 12:20:13",
                                    modifier = Modifier.padding(start = 12.dp),
                                    fontSize = 12.sp,
                                    color = MaterialTheme.colors.gray500
                                )
                            }
                            Text(
                                text = "Hello, dear users of One Aviation Administration. Happy New Year, may all your wishes come true. And we have a new batch of updates for you:",
                                modifier = Modifier.padding(start = 18.dp, end = 18.dp, top = 12.dp),
                                fontSize = 16.sp
                            )
                            Text(
                                text = "Unfold",
                                modifier = Modifier.padding(start = 18.dp),
                                fontSize = 12.sp,
                                color = Color.Blue,
                                textDecoration = TextDecoration.Underline
                            )
                        }
                    } else {
                        Column {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(
                                    text = "Account status",
                                    modifier = Modifier.padding(start = 18.dp, end = 18.dp, top = 18.dp),
                                    fontSize = 20.sp
                                )
                                Text(
                                    text = "0 ₸ for current month",
                                    modifier = Modifier.padding(start = 12.dp, top = 18.dp),
                                    fontSize = 12.sp,
                                    color = green
                                )
                            }
                            Row {
                                Card(
                                    modifier = Modifier.padding(start = 18.dp, end = 18.dp, top = 18.dp)
                                        .requiredHeight(100.dp).requiredWidth(180.dp),
                                    backgroundColor = green.copy(alpha = 0.2f),
                                    elevation = 0.dp
                                ) {
                                    Text(
                                        text = "Bonus",
                                        fontWeight = FontWeight.SemiBold,
                                        modifier = Modifier.padding(12.dp)
                                    )
                                    Text(
                                        text = "Bonus account",
                                        modifier = Modifier.padding(start = 12.dp, end = 12.dp, top = 24.dp),
                                        fontSize = 12.sp,
                                        color = MaterialTheme.colors.gray900
                                    )
                                    Text(
                                        text = "-551 660 ₸",
                                        modifier = Modifier.padding(start = 12.dp, end = 12.dp, top = 64.dp)
                                    )
                                }
                                Card(
                                    modifier = Modifier.padding(start = 18.dp, end = 18.dp, top = 18.dp)
                                        .requiredHeight(100.dp).requiredWidth(180.dp),
                                    backgroundColor = MaterialTheme.colors.primary.copy(alpha = 0.2f),
                                    elevation = 0.dp
                                ) {
                                    Text(
                                        text = "Bonus Gold",
                                        fontWeight = FontWeight.SemiBold,
                                        modifier = Modifier.padding(12.dp)
                                    )
                                    Text(
                                        text = "Bonus account",
                                        modifier = Modifier.padding(start = 12.dp, end = 12.dp, top = 24.dp),
                                        fontSize = 12.sp,
                                        color = MaterialTheme.colors.gray900
                                    )
                                    Text(
                                        text = "-430 120 ₸",
                                        modifier = Modifier.padding(start = 12.dp, end = 12.dp, top = 64.dp)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}