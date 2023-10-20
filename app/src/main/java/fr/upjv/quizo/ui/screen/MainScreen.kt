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
import androidx.compose.ui.unit.dp
import fr.upjv.quizo.ui.theme.Palered

@Composable
fun MainScreen(
    onButtonClick: () -> Unit,
    onButtonClick2: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Button(
            content = {
                Text("Go to Information Screen")
            },
            onClick = { onButtonClick() },
            colors =  ButtonDefaults.buttonColors(containerColor = Palered),
            modifier = Modifier.padding(8.dp)
        )

        Button(
            content = {
                Text("Go to Quiz Screen")
            },
            onClick = {
                onButtonClick2()
            },
            colors =  ButtonDefaults.buttonColors(containerColor = Palered),
            modifier = Modifier.padding(8.dp)
        )

    }
}