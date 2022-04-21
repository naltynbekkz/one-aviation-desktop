package main.settings

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import main.allTabs

@OptIn(
    ExperimentalComposeUiApi::class, ExperimentalFoundationApi::class, ExperimentalUnitApi::class,
    ExperimentalMaterialApi::class
)
@Composable
fun SettingsScreen(
    settingsComponent: SettingsComponent,
    navigateToAirplane: () -> Unit,
    navigateToBilling: () -> Unit,
    navigateToSms: () -> Unit,
    navigateToRights: () -> Unit
) {
    LazyVerticalGrid(
        modifier = Modifier.fillMaxWidth(),
        cells = GridCells.Adaptive(600.dp),
    ) {

        items(1) { it ->
            Card(
                modifier = Modifier
                    .padding(24.dp)
                    .requiredHeight(440.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                elevation = 8.dp,
            ) {
                Column {
                    Text(
                        text = "Main Settings",
                        modifier = Modifier.padding(18.dp).fillMaxWidth(),
                        textAlign = TextAlign.Start,
                        fontSize = 20.sp
                    )

                    LazyVerticalGrid(
                        modifier = Modifier.fillMaxSize(),
                        cells = GridCells.Adaptive(400.dp)
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
                                    onClick = { navigateToAirplane.invoke() }
                                ) {
                                    Column(
                                        modifier = Modifier.fillParentMaxSize(),
                                        verticalArrangement = Arrangement.Center
                                    ) {
                                        Text(
                                            text = "Airplane",
                                            modifier = Modifier.padding(horizontal = 12.dp),
                                            fontSize = 14.sp
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
                                    onClick = {
                                        navigateToBilling.invoke()
                                    }
                                ) {
                                    Column(
                                        modifier = Modifier.fillParentMaxSize(),
                                        verticalArrangement = Arrangement.Center
                                    ) {
                                        Text(
                                            text = "Billing",
                                            modifier = Modifier.padding(horizontal = 12.dp).fillMaxWidth(),
                                            fontSize = 14.sp
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
                                    onClick = {
                                        navigateToRights.invoke()
                                    }
                                ) {
                                    Column(
                                        modifier = Modifier.fillParentMaxSize(),
                                        verticalArrangement = Arrangement.Center
                                    ) {
                                        Text(
                                            text = "Rights",
                                            modifier = Modifier.padding(horizontal = 12.dp).fillMaxWidth(),
                                            fontSize = 14.sp
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
                                    onClick = {
                                        navigateToSms.invoke()
                                    }
                                ) {
                                    Column(
                                        modifier = Modifier.fillParentMaxSize(),
                                        verticalArrangement = Arrangement.Center
                                    ) {
                                        Text(
                                            text = "Sms settings",
                                            modifier = Modifier.padding(horizontal = 12.dp).fillMaxWidth(),
                                            fontSize = 14.sp
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
}


@OptIn(
    ExperimentalComposeUiApi::class, ExperimentalFoundationApi::class, ExperimentalUnitApi::class,
    ExperimentalMaterialApi::class
)
@Composable
fun SettingsOld(settingsComponent: SettingsComponent) {
    val nightMode by settingsComponent.nightMode.collectAsState()

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
                        Icon(
                            Icons.Filled.ArrowDropDown, "contentDescription",
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
    }
}
