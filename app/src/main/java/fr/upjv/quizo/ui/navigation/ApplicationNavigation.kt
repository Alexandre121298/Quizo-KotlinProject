package fr.upjv.quizo.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import fr.upjv.quizo.ui.screen.MainScreen

object NavigationPath {
    const val MAIN_SCREEN = "main_screen"
    const val INFORMATION_SCREEN = "Information_screen"
    const val QUIZ_SCREEN = "quiz_screen"
}

fun NavGraphBuilder.addMainScreenNav(
    onButtonClick: () -> Unit,
    onButtonClick2: () -> Unit,
) {
    composable(
        route = NavigationPath.MAIN_SCREEN
    ) {
        MainScreen(
            onButtonClick = {
                onButtonClick()
            },

            onButtonClick2 = {
                onButtonClick2()
            }
        )
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
            onButtonClick = {navController.navigate(NavigationPath.INFORMATION_SCREEN)},
            onButtonClick2 = {navController.navigate(NavigationPath.QUIZ_SCREEN)}
        )
        //addListScreenNavigation()
        //addQuoteScreenNavigation()
    }
}