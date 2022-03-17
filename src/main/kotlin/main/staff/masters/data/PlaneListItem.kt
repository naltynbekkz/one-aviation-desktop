package main.staff.masters.data

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import theme.green
import theme.typography

@Composable
fun PlaneListItem(plane: Plane) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Plane")
                },
                navigationIcon = {
                    IconButton(onClick = {
                        // navigateUp()
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

        Box(Modifier.fillMaxSize(), Alignment.Center) {

            var name: String by remember { mutableStateOf(plane.name) }
            var mileage: String by remember { mutableStateOf(plane.mileage.toString()) }
            var price: String by remember { mutableStateOf(plane.price.toString()) }
            var capacity: String by remember { mutableStateOf(plane.capacity.toString()) }

            var isEdit: Boolean by remember { mutableStateOf(false) }

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Plane Info", modifier = Modifier.padding(16.dp), fontSize = 24.sp
                )

                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp).wrapContentWidth(),
                    label = { Text("Name") },
                    enabled = isEdit
                )

                OutlinedTextField(
                    value = mileage,
                    onValueChange = { mileage = it },
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp).wrapContentWidth(),
                    label = { Text("Mileage") },
                    enabled = isEdit
                )

                OutlinedTextField(
                    value = price,
                    onValueChange = { price = it },
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp).wrapContentWidth(),
                    label = { Text("Price") },
                    enabled = isEdit
                )

                OutlinedTextField(
                    value = capacity,
                    onValueChange = { capacity = it },
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp).wrapContentWidth(),
                    label = { Text("Capacity") },
                    enabled = isEdit
                )

                Button(
                    onClick = { isEdit = !isEdit }, colors = if (isEdit) {
                        ButtonDefaults.buttonColors(green, Color.White)
                    } else {
                        ButtonDefaults.buttonColors()
                    }
                ) {
                    if (!isEdit) {
                        Text(text = "Edit")
                    } else {
                        Text(text = "Save")
                    }
                }
            }
        }
    }
}

@Composable
fun initialView(plane: Plane) {
    Card(
        modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp).fillMaxWidth(),
        elevation = 2.dp,
        backgroundColor = Color.White,
        shape = RoundedCornerShape(corner = CornerSize(16.dp))
    ) {
        Row {
            Column(
                modifier = Modifier.padding(16.dp).fillMaxWidth().align(Alignment.CenterVertically)
            ) {
                Text(text = plane.name, style = typography.h6)
                Text(text = "Capacity ${plane.capacity}", style = typography.caption)
            }
        }
    }
}
