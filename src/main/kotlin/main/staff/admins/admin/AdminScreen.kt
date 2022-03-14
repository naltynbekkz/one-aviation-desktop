package main.staff.admins.admin

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import core.ResponseComponent

@OptIn(ExperimentalComposeUiApi::class, ExperimentalFoundationApi::class)
@Composable
fun AdminScreen(
    component: AdminComponent,
    navigateUp: () -> Unit,
) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Admin")
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
                actions = {
                    IconButton(onClick = {
                        component.admin.refresh()
                    }) {
                        Icon(Icons.Default.Refresh, null)
                    }
                }
            )
        }
    ) {
        ResponseComponent(
            interactor = component.admin,
        ) { admin ->
            Text(admin.toString())
        }
    }

}