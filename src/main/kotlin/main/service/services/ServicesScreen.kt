package main.service.services

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import core.VerticalDivider

@Composable
fun ServicesScreen(component: ServicesComponent) {

    val services = listOf(
        Service(0, "Наращивание ресниц 3D", 6000, 8000, 65, "", 1),
        Service(0, "Ламинация ресниц", 4000, 6000, 65, "", 2),
        Service(0, "Массаж спины", 8000, 12000, 30, "", 0),
        Service(0, "Brown Lashes", 6000, 8000, 180, "", 3),
        Service(0, "Ламинирование+ботокс ресниц", 6000, 8000, 90, "", 2),
        Service(0, "Коррекция ресниц", 6000, 8000, 35, "", 0),
        Service(0, "Добавление цветных ресниц", 6000, 8000, 60, "", 1),
        Service(0, "Голливудский объем", 6000, 8000, 60, "", 1),
        Service(0, "Окрашивание бровей хной ", 6000, 8000, 15, "", 2),
        Service(0, "Наращивание ресниц 3D", 6000, 8000, 65, "", 1),
        Service(0, "Ламинация ресниц", 4000, 6000, 65, "", 2),
        Service(0, "Массаж спины", 8000, 12000, 30, "", 0),
        Service(0, "Brown Lashes", 6000, 8000, 180, "", 3),
        Service(0, "Ламинирование+ботокс ресниц", 6000, 8000, 90, "", 2),
        Service(0, "Коррекция ресниц", 6000, 8000, 35, "", 0),
        Service(0, "Добавление цветных ресниц", 6000, 8000, 60, "", 1),
        Service(0, "Голливудский объем", 6000, 8000, 60, "", 1),
        Service(0, "Окрашивание бровей хной ", 6000, 8000, 15, "", 2),
        Service(0, "Наращивание ресниц 3D", 6000, 8000, 65, "", 1),
        Service(0, "Ламинация ресниц", 4000, 6000, 65, "", 2),
        Service(0, "Массаж спины", 8000, 12000, 30, "", 0),
        Service(0, "Brown Lashes", 6000, 8000, 180, "", 3),
        Service(0, "Ламинирование+ботокс ресниц", 6000, 8000, 90, "", 2),
        Service(0, "Коррекция ресниц", 6000, 8000, 35, "", 0),
        Service(0, "Добавление цветных ресниц", 6000, 8000, 60, "", 1),
        Service(0, "Голливудский объем", 6000, 8000, 60, "", 1),
        Service(0, "Окрашивание бровей хной ", 6000, 8000, 15, "", 2),
        Service(0, "Наращивание ресниц 3D", 6000, 8000, 65, "", 1),
        Service(0, "Ламинация ресниц", 4000, 6000, 65, "", 2),
        Service(0, "Массаж спины", 8000, 12000, 30, "", 0),
        Service(0, "Brown Lashes", 6000, 8000, 180, "", 3),
        Service(0, "Ламинирование+ботокс ресниц", 6000, 8000, 90, "", 2),
        Service(0, "Коррекция ресниц", 6000, 8000, 35, "", 0),
        Service(0, "Добавление цветных ресниц", 6000, 8000, 60, "", 1),
        Service(0, "Голливудский объем", 6000, 8000, 60, "", 1),
        Service(0, "Окрашивание бровей хной ", 6000, 8000, 15, "", 2),
    )

    val state = rememberLazyListState()

    LazyColumn(
        modifier = Modifier,
        state = state,
        contentPadding = PaddingValues(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        item {
            Text("Header")
        }
        item {
            Divider()
        }
        items(services) {

            Row(
                modifier = Modifier.fillMaxSize().height(80.dp),
            ) {
                VerticalDivider()
                Box(
                    modifier = Modifier.weight(1f).fillMaxHeight(),
                    contentAlignment = Alignment.Center,
                ) {
                    Text(
                        text = it.id.toString(),
                        textAlign = TextAlign.Center,
                    )
                }
                VerticalDivider()
                Box(
                    modifier = Modifier.weight(1f).fillMaxHeight(),
                    contentAlignment = Alignment.Center,
                ) {
                    Text(
                        text = it.name,
                        textAlign = TextAlign.Center,
                    )
                }
                VerticalDivider()
                Box(
                    modifier = Modifier.weight(1f).fillMaxHeight(),
                    contentAlignment = Alignment.Center,
                ) {
                    Text(
                        text = "${it.priceMin} - ${it.priceMax}",
                        textAlign = TextAlign.Center,
                    )
                }
                VerticalDivider()
                Box(
                    modifier = Modifier.weight(1f).fillMaxHeight(),
                    contentAlignment = Alignment.Center,
                ) {
                    Text(
                        text = "${it.duration} minutes",
                        textAlign = TextAlign.Center,
                    )
                }
                VerticalDivider()
                Box(
                    modifier = Modifier.weight(1f).fillMaxHeight(),
                    contentAlignment = Alignment.Center,
                ) {
                    Text(
                        text = it.description,
                        textAlign = TextAlign.Center,
                    )
                }
                VerticalDivider()
                Box(
                    modifier = Modifier.weight(1f).fillMaxHeight(),
                    contentAlignment = Alignment.Center,
                ) {
                    Text(
                        text = it.staffCount.toString(),
                        textAlign = TextAlign.Center,
                    )
                }
                VerticalDivider()
            }
            Divider()
        }

        item {
            Divider()
        }
    }

}