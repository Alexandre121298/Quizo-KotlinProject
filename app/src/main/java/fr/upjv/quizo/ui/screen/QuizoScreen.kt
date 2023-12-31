package fr.upjv.quizo.ui.screen

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import fr.upjv.quizo.ui.model.QuizzItemUI
import fr.upjv.quizo.ui.theme.Palered
import fr.upjv.quizo.ui.viewmodel.QuizzViewModel

@Composable
fun QuizoScreen() {

    val viewModel: QuizzViewModel = viewModel()
    val list = viewModel.questions.collectAsState(emptyList()).value


    LazyColumn(
        modifier = Modifier.padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        items(count = list.size)
        {
            val context = LocalContext.current
            when (val currentItem = list[it]){
                is QuizzItemUI.Header -> Text(
                    modifier = Modifier
                        .background(Palered, shape = CircleShape)
                        .fillMaxWidth()
                        .padding(8.dp),
                    text = "Categorie = ${currentItem.category}"
                )

                is QuizzItemUI.QuizzItem -> Text(
                    text = "Question : ${currentItem.question} \n\n" +
                            "Reponse A : ${currentItem.reponseA} \n\n" +
                            "Reponse B : ${currentItem.reponseB} \n\n" +
                            "Reponse C : ${currentItem.reponseC} \n\n" +
                            "Reponse D : ${currentItem.reponseD} \n\n",
                    color = Color.White,
                    modifier = Modifier.clickable {
                        val toast = Toast.makeText(context, "C'est une question !", Toast.LENGTH_LONG)
                        toast.show()
                    }
                )

                is QuizzItemUI.Footer -> Text(
                    modifier = Modifier
                        .background(Color.White, shape = CircleShape)
                        .fillMaxWidth()
                        .padding(8.dp),
                    text = "Footer = ${currentItem.timestamp}"
                )

                is QuizzItemUI.Header -> Text(text = "Categorie = ${currentItem.category}")
                is QuizzItemUI.QuizzItem -> Text(text = "Question : ${currentItem.question} \n\n" +
                        "Reponse A : ${currentItem.reponseA} \n\n" +
                        "Reponse B : ${currentItem.reponseB} \n\n" +
                        "Reponse C : ${currentItem.reponseC} \n\n" +
                        "Reponse D : ${currentItem.reponseD} \n\n")
                is QuizzItemUI.Footer -> Text(text = "timestamp : ${currentItem.timestamp}")
            }

        }

        item {
            Button(
                content = { Text("Add") },
                onClick = { viewModel.insertNewQuestion() },
                colors =  ButtonDefaults.buttonColors(containerColor = Palered),
            )
            Button(
                content = { Text("Delete") },
                onClick = { viewModel.deleteAllQuestions() },
                colors =  ButtonDefaults.buttonColors(containerColor = Palered),
            )
        }
    }
}