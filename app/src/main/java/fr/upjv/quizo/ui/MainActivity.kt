package fr.upjv.quizo.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import fr.upjv.quizo.R
import fr.upjv.quizo.ui.theme.QuizoTheme

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    val DarkGrey = fr.upjv.quizo.ui.theme.DarkGrey


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuizoTheme {
                Scaffold(
                    topBar = {
                        TopAppBar( //Barre de navigation en haut de l'ecran
                            navigationIcon = {
                                Icon(
                                    imageVector = Icons.Default.ArrowBack,
                                    contentDescription = null,
                                    tint = Color.White
                                )
                            },
                            title = {
                                Text(text = stringResource(id = R.string.app_name),
                                    color = Color.White)
                                    },
                            colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = DarkGrey)
                        )
                    },
                    bottomBar = {
                        BottomAppBar { Text("Work in progress") }
                    },
                )
                { paddingValues ->
                    Text(
                        modifier = Modifier.padding(paddingValues),
                        text = "content"
                    )
                }

            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    QuizoTheme {
        Greeting("Android")
    }
}