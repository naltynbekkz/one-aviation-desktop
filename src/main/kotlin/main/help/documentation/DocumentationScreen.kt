package main.help.documentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DocumentationScreen(component: DocumentationComponent) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Documentation", modifier = Modifier.padding(start = 20.dp))
                },
                backgroundColor = MaterialTheme.colors.background,
            )
        }
    ) {
        Card(
            modifier = Modifier
                .padding(24.dp)
                .requiredHeight(460.dp)
                .requiredWidth(660.dp),
            shape = RoundedCornerShape(12.dp),
            elevation = 8.dp,
        ) {
            Column(modifier = Modifier.padding(horizontal = 44.dp, vertical = 36.dp)) {
                Text(
                    text = "This is a documentation about how to use the application",
                    modifier = Modifier.padding(bottom = 22.dp),
                    fontSize = 20.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = "If you want to see the general operations that application perform you should visit",
                    modifier = Modifier.padding(bottom = 14.dp)
                )
                Text(
                    text = "Home page",
                    color = Color.Blue,
                    modifier = Modifier.padding(bottom = 14.dp).clickable { })
                Text(
                    text = "If you want to see the user's logged in and out times, then you should visit",
                    modifier = Modifier.padding(bottom = 14.dp)
                )
                Text(
                    text = "Logs page",
                    color = Color.Blue,
                    modifier = Modifier.padding(bottom = 14.dp).clickable { })
                Text(
                    text = "In the \"Settings\" page you can edit settings of the application or can be familiar need to be modified",
                    modifier = Modifier.padding(bottom = 14.dp)
                )
                Text(
                    text = "Settings page",
                    color = Color.Blue,
                    modifier = Modifier.padding(bottom = 14.dp).clickable { })
                Text(
                    text = "If you need some help while working with the application, you can move to",
                    modifier = Modifier.padding(bottom = 14.dp)
                )
                Text(
                    text = "Help page",
                    color = Color.Blue,
                    modifier = Modifier.padding(bottom = 14.dp).clickable { })
            }
        }
    }
}