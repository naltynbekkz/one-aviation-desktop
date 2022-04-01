package main.settings.settings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.toSize
import core.isNotConsumed
import main.allTabs
import main.settings.navigation.SettingsDestination

@Composable
fun SettingsScreen(
    settingsComponent: SettingsComponent,
    navigate: (SettingsDestination) -> Unit,
) {

    val nightMode by settingsComponent.nightMode.collectAsState()

    val scaffoldState = rememberScaffoldState()

    val navigationResult by settingsComponent.navigationResult.collectAsState()

    LaunchedEffect(navigationResult) {
        if (navigationResult.isNotConsumed()) {

            navigationResult!!.args.entries.forEach { (key, value) ->
                if (value as? Boolean == true) {
                    val result = scaffoldState.snackbarHostState.showSnackbar("asdf")
                    when (result) {
                        SnackbarResult.Dismissed -> {

                        }
                        SnackbarResult.ActionPerformed -> {

                        }
                    }
                }
            }
        }
    }

    Scaffold(scaffoldState = scaffoldState) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            Row {

                Column {

                    Text(
                        text = "FirmSettings",
                        modifier = Modifier.clickable {
                            navigate(SettingsDestination.FirmSettings)
                        }
                    )
                    Text(
                        text = "Billing",
                        modifier = Modifier.clickable {
                            navigate(SettingsDestination.Billing)
                        }
                    )
                    Text(
                        text = "SmsSettings",
                        modifier = Modifier.clickable {
                            navigate(SettingsDestination.SmsSettings)
                        }
                    )
                    Text(
                        text = "PermissionsSettings",
                        modifier = Modifier.clickable {
                            navigate(SettingsDestination.PermissionsSettings)
                        }
                    )
                    Text(
                        text = "Deals",
                        modifier = Modifier.clickable {
                            navigate(SettingsDestination.Deals)
                        }
                    )
                }

                Column {
                    Text(
                        text = "LogsSettings",
                        modifier = Modifier.clickable {
                            navigate(SettingsDestination.LogsSettings)
                        }
                    )
                    Text(
                        text = "WorkplacesSettings",
                        modifier = Modifier.clickable {
                            navigate(SettingsDestination.WorkplacesSettings)
                        }
                    )
                    Text(
                        text = "SourcesSettings",
                        modifier = Modifier.clickable {
                            navigate(SettingsDestination.SourcesSettings)
                        }
                    )
                    Text(
                        text = "DiscountSettings",
                        modifier = Modifier.clickable {
                            navigate(SettingsDestination.DiscountSettings)
                        }
                    )
                    Text(
                        text = "Actions",
                        modifier = Modifier.clickable {
                            navigate(SettingsDestination.Actions)
                        }
                    )
                }

            }

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
        }
    }
}