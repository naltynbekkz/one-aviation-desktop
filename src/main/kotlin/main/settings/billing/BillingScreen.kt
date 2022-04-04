package main.settings.billing

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterialApi::class)
@Composable
fun BillingScreen(
    billingComponent: BillingComponent,
    navigateUp: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Billing")
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
        Column(modifier = Modifier.padding(horizontal = 64.dp, vertical = 46.dp).fillMaxSize()) {
            Text(
                text = "Expires 01 September 2030",
                color = Color.Gray
            )

            Text(
                modifier = Modifier.padding(top = 14.dp),
                text = "Select a tariff plan:",
                color = Color.Black,
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold
            )

            Row(modifier = Modifier.padding(top = 12.dp).fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Column {
                    Card(
                        modifier = Modifier.requiredHeight(30.dp).requiredWidth(180.dp),
                        backgroundColor = Color.Blue.copy(alpha = 0.7f),
                        elevation = 0.dp
                    ) {
                        Text(
                            text = "Tariff \"Quarter year\"",
                            color = Color.White,
                            fontSize = 13.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                    Card(
                        modifier = Modifier.requiredHeight(200.dp).requiredWidth(180.dp),
                        elevation = 2.dp,
                        onClick = { }
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                modifier = Modifier.padding(top = 46.dp),
                                text = "25 800 ₸/month",
                                color = Color.Black,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold,
                                textAlign = TextAlign.Center
                            )
                            Text(
                                modifier = Modifier.padding(top = 12.dp),
                                text = "3 months",
                                color = Color.Gray,
                                fontSize = 12.sp,
                                textAlign = TextAlign.Center
                            )
                            Text(
                                text = "Total cost",
                                color = Color.Gray,
                                fontSize = 12.sp,
                                textAlign = TextAlign.Center
                            )
                            Text(
                                text = "77 400 ₸",
                                color = Color.Gray,
                                fontSize = 12.sp,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
                Column(modifier = Modifier.padding(start = 46.dp)) {
                    Card(
                        modifier = Modifier.requiredHeight(30.dp).requiredWidth(180.dp),
                        backgroundColor = Color.Blue.copy(alpha = 0.7f),
                        elevation = 0.dp
                    ) {
                        Text(
                            text = "Tariff \"Half year\"",
                            color = Color.White,
                            fontSize = 13.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                    Card(
                        modifier = Modifier.requiredHeight(200.dp).requiredWidth(180.dp),
                        elevation = 2.dp,
                        onClick = { }
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                modifier = Modifier.padding(top = 46.dp),
                                text = "19 800 ₸/month",
                                color = Color.Black,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold,
                                textAlign = TextAlign.Center
                            )
                            Text(
                                modifier = Modifier.padding(top = 12.dp),
                                text = "6 months",
                                color = Color.Gray,
                                fontSize = 12.sp,
                                textAlign = TextAlign.Center
                            )
                            Text(
                                text = "Total cost",
                                color = Color.Gray,
                                fontSize = 12.sp,
                                textAlign = TextAlign.Center
                            )
                            Text(
                                text = "118 800 ₸ (- 24%)",
                                color = Color.Gray,
                                fontSize = 12.sp,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
                Column(modifier = Modifier.padding(start = 46.dp)) {
                    Card(
                        modifier = Modifier.requiredHeight(30.dp).requiredWidth(180.dp),
                        backgroundColor = Color.Blue.copy(alpha = 0.7f),
                        elevation = 0.dp
                    ) {
                        Text(
                            text = "Tariff \"A year\"",
                            color = Color.White,
                            fontSize = 13.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                    Card(
                        modifier = Modifier.requiredHeight(200.dp).requiredWidth(180.dp),
                        elevation = 2.dp,
                        onClick = { }
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                modifier = Modifier.padding(top = 46.dp),
                                text = "17 800 ₸/month",
                                color = Color.Black,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold,
                                textAlign = TextAlign.Center
                            )
                            Text(
                                modifier = Modifier.padding(top = 12.dp),
                                text = "1 year",
                                color = Color.Gray,
                                fontSize = 12.sp,
                                textAlign = TextAlign.Center
                            )
                            Text(
                                text = "Total cost",
                                color = Color.Gray,
                                fontSize = 12.sp,
                                textAlign = TextAlign.Center
                            )
                            Text(
                                text = "213 600 ₸ (- 32%)",
                                color = Color.Gray,
                                fontSize = 12.sp,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
                Column(modifier = Modifier.padding(start = 46.dp)) {
                    Card(
                        modifier = Modifier.requiredHeight(30.dp).requiredWidth(180.dp),
                        backgroundColor = Color.Blue.copy(alpha = 0.7f),
                        elevation = 0.dp
                    ) {
                        Text(
                            text = "Tariff \"Two year\"",
                            color = Color.White,
                            fontSize = 13.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                    Card(
                        modifier = Modifier.requiredHeight(200.dp).requiredWidth(180.dp),
                        elevation = 2.dp,
                        onClick = { }
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                modifier = Modifier.padding(top = 46.dp),
                                text = "15 800 ₸/month",
                                color = Color.Black,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold,
                                textAlign = TextAlign.Center
                            )
                            Text(
                                modifier = Modifier.padding(top = 12.dp),
                                text = "2 years",
                                color = Color.Gray,
                                fontSize = 12.sp,
                                textAlign = TextAlign.Center
                            )
                            Text(
                                text = "Total cost",
                                color = Color.Gray,
                                fontSize = 12.sp,
                                textAlign = TextAlign.Center
                            )
                            Text(
                                text = "379 200 ₸ (- 39%)",
                                color = Color.Gray,
                                fontSize = 12.sp,
                                textAlign = TextAlign.Center
                            )
                            Text(
                                modifier = Modifier.padding(top = 12.dp),
                                text = "The most profitable",
                                color = Color.Green,
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Thin,
                                textAlign = TextAlign.Start
                            )
                        }
                    }
                }
            }
        }
    }
}