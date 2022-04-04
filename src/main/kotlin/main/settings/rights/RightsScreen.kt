package main.settings.rights

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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import theme.green

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterialApi::class)
@Composable
fun RightsScreen(
    rightsComponent: RightsComponent,
    navigateUp: () -> Unit
) {

    var rightsEditText: String by remember {
        mutableStateOf(
            "#1 Responsibility to understand one’s own perspective and the perspectives of others on global issues:" +
                    "\n\n// you should complete it\n\n# 2 Responsibility to respect the principle of cultural diversity:\n\n// you should complete it\n\n" +
                    "# 3 Responsibility to make connections and build relationships with people from other countries and cultures:\n\n// you should complete it"
        )
    }

    val isItObligatory = remember { mutableStateOf(false) }

    Scaffold(topBar = {
        TopAppBar(
            title = {
                Text("Rights")
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
    }) {
        LazyVerticalGrid(
            modifier = Modifier.fillMaxWidth(),
            cells = GridCells.Adaptive(600.dp),
        ) {

            items(1) { it ->
                Card(
                    modifier = Modifier.padding(24.dp).requiredHeight(500.dp).fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    elevation = 8.dp,
                ) {
                    Column {
                        Text(
                            text = "Rights",
                            modifier = Modifier.padding(18.dp).fillMaxWidth(),
                            textAlign = TextAlign.Start,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colors.primary
                        )
                        Text(
                            modifier = Modifier.padding(start = 18.dp),
                            text = "You can create rights or change if it exists",
                            fontSize = 16.sp,
                            fontStyle = FontStyle.Italic
                        )
                        OutlinedTextField(value = rightsEditText,
                            onValueChange = { rightsEditText = it },
                            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 8.dp).fillMaxWidth(),
                            label = { Text("Edit rights") })

                        Row(
                            modifier = Modifier.padding(start = 2.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Checkbox(
                                checked = isItObligatory.value,
                                onCheckedChange = {
                                    isItObligatory.value = it
                                },
                                modifier = Modifier.wrapContentSize()
                            )
                            Text(text = "Make it obligatory")
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