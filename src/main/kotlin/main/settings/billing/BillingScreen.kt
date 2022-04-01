package main.settings.billing

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BillingScreen(
    component: BillingComponent,
    navigateUp: () -> Unit,
) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("BillingScreen")
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

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {

            Column(
                modifier = Modifier
                    .width(IntrinsicSize.Max)
                    .fillMaxHeight()
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {

                Text(
                    text = "Срок Действия истекает 01 сентября 2030 года",
                )
                Text(
                    text = "Выберите тарифный план",
                )

                Row(horizontalArrangement = Arrangement.spacedBy(24.dp)) {
                    repeat(4) {
                        Card(
                            onClick = {
                                component.setNavigationResultAndNavigateUp(mapOf("result" to true))
                            }
                        ) {
                            Column(
                                modifier = Modifier.width(IntrinsicSize.Max),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .background(Color.Blue)
                                        .padding(16.dp),
                                ) {
                                    Text(
                                        text = "Тариф Квартальный",
                                        color = Color.White,
                                    )
                                }
                                Text(
                                    text = "25 800 т/мес",
                                    modifier = Modifier.padding(top = 24.dp),
                                    style = MaterialTheme.typography.subtitle1,
                                )
                                Text(
                                    text = "3 месяца",
                                    modifier = Modifier.padding(top = 12.dp),
                                )
                                Text(text = "Общая стоимость")
                                Text(text = "77 400 т", modifier = Modifier.padding(bottom = 24.dp))
                            }
                        }
                    }
                }
            }
        }
    }
}