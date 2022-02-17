package main.settings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
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
import main.allTabs

@Composable
fun SettingsScreen(settingsComponent: SettingsComponent) {

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