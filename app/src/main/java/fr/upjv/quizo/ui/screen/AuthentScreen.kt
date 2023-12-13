package fr.upjv.quizo.ui.screen

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import fr.upjv.quizo.ui.viewmodel.AuthentViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthentScreen(){

    val AuthentViewModel: AuthentViewModel = viewModel()
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var CurrentUserId by remember { mutableStateOf("") }

    LazyColumn(
        modifier = Modifier.padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        item {
            TextField(
                value = username,
                onValueChange = { username = it },
                label = { Text("Nom d'utilisateur") }
            )
            Spacer(modifier = Modifier.height(16.dp))
            TextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Mot de passe") },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )
        }
        
        item {
            Text(
                text = "ID current User : $CurrentUserId",
                fontSize = 20.sp,
                color = Color.White,
                modifier = Modifier.padding(bottom = 16.dp)

            )
        }

        item {
            Button(
                content = { Text("Inscription") },
                onClick = {
                    //val toast = Toast.makeText(LocalContext,"",Toast.LENGTH_LONG)
                    if(AuthentViewModel.Checkfields(username,password)){
                        AuthentViewModel.Inscription(username,password)
                    }
                    else
                    {
                        //TODO Toast here
                    }

                }
            )

            Button(
                content = { Text("Connexion") },
                onClick = {
                    if(AuthentViewModel.Checkfields(username, password)){
                        AuthentViewModel.Connexion(username, password)
                        CurrentUserId = AuthentViewModel.getCurrentUserId().toString()
                    }
                    else
                    {
                        //Todo Toast here
                    }

                }
            )
        }
    }
}