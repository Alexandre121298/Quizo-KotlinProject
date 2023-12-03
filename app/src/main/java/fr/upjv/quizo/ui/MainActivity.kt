package fr.upjv.quizo.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.navigation.compose.rememberNavController
import fr.upjv.quizo.R
import fr.upjv.quizo.ui.navigation.HomeNavHost
import fr.upjv.quizo.ui.theme.QuizoTheme

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    val DarkGrey = fr.upjv.quizo.ui.theme.DarkGrey


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            QuizoTheme {
                Scaffold(
                    topBar = {
                        //Barre de navigation en haut de l'ecran
                        TopAppBar(
                            navigationIcon = {
                                IconButton(onClick = {
                                    navController.popBackStack()
                                }) {
                                    Icon(
                                        imageVector = Icons.Default.ArrowBack,
                                        contentDescription = null,
                                        tint = Color.White
                                    ) //Fleche de retour du header
                                }
                            },
                            title = {
                                Text(text = stringResource(id = R.string.app_name),
                                    color = Color.White)
                                    },  //Titre du "header" de l'application
                            colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = DarkGrey)
                        )
                    },
                    bottomBar = {
                        BottomAppBar { Text("Work in progress") }
                    },
                )
                {
                    Box(modifier = Modifier
                        .fillMaxSize()
                        .padding(it)
                        .background(DarkGrey))
                    {
                        HomeNavHost(navController = navController)
                    }
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