package fr.upjv.quizo.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import fr.upjv.quizo.ui.screen.AuthentScreen
import fr.upjv.quizo.ui.screen.MainScreen
import fr.upjv.quizo.ui.screen.QuizoScreen

object NavigationPath {
    const val MAIN_SCREEN = "main_screen"
    const val QUIZ_SCREEN = "quiz_screen"
    const val AUTHENT_SCREEN = "authent_screen"
}

fun NavGraphBuilder.addMainScreenNav(
    onButtonClick: () -> Unit,
    onButtonAuthentClick:() -> Unit,
) {
    composable(
        route = NavigationPath.MAIN_SCREEN
    ) {
        MainScreen(
            onButtonClick = {
                onButtonClick()
            },

            onButtonAuthentClick = {
                onButtonAuthentClick()
            },
        )
    }
}

fun NavGraphBuilder.addQuizoScreenNavigation(){
    composable(
        route = NavigationPath.QUIZ_SCREEN,
    ) {
        QuizoScreen()
    }
}

fun NavGraphBuilder.addQuizoAuthentNavigation(){
    composable(
        route = NavigationPath.AUTHENT_SCREEN,
    ){
        AuthentScreen()
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
            onButtonClick = {navController.navigate(NavigationPath.QUIZ_SCREEN)},
            onButtonAuthentClick = {navController.navigate((NavigationPath.AUTHENT_SCREEN))}
        )
        addQuizoScreenNavigation()
        addQuizoAuthentNavigation()
    }
}