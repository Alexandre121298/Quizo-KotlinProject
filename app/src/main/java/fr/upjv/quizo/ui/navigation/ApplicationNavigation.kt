package fr.upjv.quizo.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import fr.upjv.quizo.ui.screen.InformationScreen
import fr.upjv.quizo.ui.screen.MainScreen
import fr.upjv.quizo.ui.screen.QuizoScreen

object NavigationPath {
    const val MAIN_SCREEN = "main_screen"
    const val QUIZ_SCREEN = "quiz_screen"
}

fun NavGraphBuilder.addMainScreenNav(
    onButtonClick: () -> Unit,
) {
    composable(
        route = NavigationPath.MAIN_SCREEN
    ) {
        MainScreen {
            onButtonClick()
        }
    }
}

fun NavGraphBuilder.addQuizoScreenNavigation(){
    composable(
        route = NavigationPath.QUIZ_SCREEN,
    ) {
        QuizoScreen()
    }
}


@Composable
fun HomeNavHost(
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = NavigationPath.MAIN_SCREEN,
    ) {
        addMainScreenNav(
            onButtonClick = {navController.navigate(NavigationPath.QUIZ_SCREEN)}
        )
        addQuizoScreenNavigation()
    }
}