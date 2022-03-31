package main.settings

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalComposeUiApi::class, ExperimentalFoundationApi::class, ExperimentalUnitApi::class)
@Composable
fun SettingsScreen(settingsComponent: SettingsComponent) {


    LazyVerticalGrid(
        modifier = Modifier.fillMaxWidth(),
        cells = GridCells.Adaptive(600.dp),
    ) {

        items(2) { it ->
            Card(
                modifier = Modifier
                    .padding(24.dp)
                    .requiredHeight(440.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                elevation = 8.dp,
            ) {

                if (it == 0) {
                    Column {
                        Text(
                            text = "Main Settings",
                            modifier = Modifier.padding(12.dp).fillMaxWidth(),
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
                                        Column {
                                            Text(
                                                text = "Company",
                                                modifier = Modifier.padding(horizontal = 12.dp).fillMaxWidth(),
                                                fontSize = 14.sp,
                                                textAlign = TextAlign.Start
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
                                        Column {
                                            Text(
                                                text = "Billing",
                                                modifier = Modifier.padding(horizontal = 12.dp).fillMaxWidth(),
                                                fontSize = 14.sp,
                                                textAlign = TextAlign.Start
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
                                        Column {
                                            Text(
                                                text = "Rights",
                                                modifier = Modifier.padding(horizontal = 12.dp).fillMaxWidth(),
                                                fontSize = 14.sp,
                                                textAlign = TextAlign.Start
                                            )
                                        }
                                    }
                                } else {
                                    Card(
                                        modifier = Modifier
                                            .padding(12.dp)
                                            .requiredHeight(62.dp)
                                            .fillMaxWidth(),
                                        shape = RoundedCornerShape(4.dp),
                                        elevation = 4.dp,
                                    ) {
                                        Column {
                                            Text(
                                                text = "Sms settings",
                                                modifier = Modifier.padding(horizontal = 12.dp).fillMaxWidth(),
                                                fontSize = 14.sp,
                                                textAlign = TextAlign.Start
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
                            text = "Journal",
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
                                        Column {
                                            Text(
                                                text = "Journal",
                                                modifier = Modifier.padding(horizontal = 12.dp).fillMaxWidth(),
                                                fontSize = 14.sp,
                                                textAlign = TextAlign.Start
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
                                        Column {
                                            Text(
                                                text = "Desktop",
                                                modifier = Modifier.padding(horizontal = 12.dp).fillMaxWidth(),
                                                fontSize = 14.sp,
                                                textAlign = TextAlign.Start
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
                                        Column {
                                            Text(
                                                text = "Sources",
                                                modifier = Modifier.padding(horizontal = 12.dp).fillMaxWidth(),
                                                fontSize = 14.sp,
                                                textAlign = TextAlign.Start
                                            )
                                        }
                                    }
                                } else {
                                    Card(
                                        modifier = Modifier
                                            .padding(12.dp)
                                            .requiredHeight(62.dp)
                                            .fillMaxWidth(),
                                        shape = RoundedCornerShape(4.dp),
                                        elevation = 4.dp,
                                    ) {
                                        Column {
                                            Text(
                                                text = "Discounts",
                                                modifier = Modifier.padding(horizontal = 12.dp).fillMaxWidth(),
                                                fontSize = 14.sp,
                                                textAlign = TextAlign.Start
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }


                /*val nightMode by settingsComponent.nightMode.collectAsState()

                Box(Modifier.fillMaxSize(), Alignment.Center) {
                    Column {
                        var expanded by remember { mutableStateOf(false) }

                        val startupScreen by settingsComponent.startupScreen.collectAsState()

                        var textfieldSize by remember { mutableStateOf(Size.Zero) }


                        Column {
                            OutlinedTextField(
                                value = startupScreen.title,
                                onValueChange = { },
                                modifier = Modifier
                                    .onGloballyPositioned { coordinates ->
                                        //This value is used to assign to the DropDown the same width
                                        textfieldSize = coordinates.size.toSize()
                                    },
                                label = { Text("Startup screen") },
                                readOnly = true,
                                trailingIcon = {
                                    Icon(Icons.Filled.ArrowDropDown, "contentDescription",
                                        Modifier.clickable { expanded = !expanded })
                                }
                            )
                            DropdownMenu(
                                expanded = expanded,
                                onDismissRequest = { expanded = false },
                                modifier = Modifier
                                    .width(with(LocalDensity.current) { textfieldSize.width.toDp() })
                            ) {
                                allTabs.forEach { label ->
                                    DropdownMenuItem(onClick = {
                                        settingsComponent.setStartupScreen(label)
                                        expanded = false
                                    }) {
                                        Text(text = label.title)
                                    }
                                }
                            }
                        }

                        Button({
                            settingsComponent.setNightMode(!nightMode)
                        }) {
                            Text(if (nightMode) "Night" else "Day")
                        }
                    }
                }*/
            }
        }
    }
}