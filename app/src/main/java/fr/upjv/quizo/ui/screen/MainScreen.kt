package fr.upjv.quizo.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fr.upjv.quizo.ui.theme.Palered

//Definit le menu principal
@Composable
fun MainScreen(
    onButtonClick: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Text(
            text = "Alexandre Dubois",
            style = TextStyle(
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            ),
            modifier = Modifier.padding(16.dp)
        )

        Text(
            text = "Application de Quizz ! ",
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            ),
            modifier = Modifier.padding(16.dp)
        )

        Button(
            content = {
                Text("Go to Quiz Screen")
            },
            onClick = {
                onButtonClick()
            },
            colors =  ButtonDefaults.buttonColors(containerColor = Palered),
            modifier = Modifier.padding(8.dp)
        )

    }
}