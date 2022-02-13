package main.finance.expense

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun ExpenseScreen(component: ExpenseComponent) {

    Box(Modifier.fillMaxSize(), Alignment.Center) {
        Text("ExpenseScreen")
    }

}