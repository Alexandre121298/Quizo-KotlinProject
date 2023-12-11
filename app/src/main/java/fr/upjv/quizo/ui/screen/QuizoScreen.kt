package fr.upjv.quizo.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import fr.upjv.quizo.ui.viewmodel.QuizzViewModel

@Composable
fun QuizoScreen() {

    val viewModel: QuizzViewModel = viewModel()
    val list = viewModel.questions.collectAsState(emptyList()).value


    LazyColumn(
        modifier = Modifier.padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        items(count = list.size) {
            Text(text = "Name = ${list[it].question}",
                 style = TextStyle(
                     color = Color.White
                 ),
            )
        }
        item {
            Button(
                content = { Text("Add") },
                onClick = { viewModel.insertNewQuestion() }
            )
            Button(
                content = { Text("Delete") },
                onClick = { viewModel.deleteAllQuestions() }
            )
        }
    }
}