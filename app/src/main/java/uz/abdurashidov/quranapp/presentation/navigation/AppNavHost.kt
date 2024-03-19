package uz.abdurashidov.quranapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import uz.abdurashidov.quranapp.presentation.detail.DetailScreen
import uz.abdurashidov.quranapp.presentation.home.HomeScreen
import uz.abdurashidov.quranapp.presentation.settings.SettingsScreen

@Composable
fun AppNavHost(
    modifier: Modifier,
    navController: NavHostController,
    startingDestination: String = NavigationItem.Home.route
) {
    NavHost(navController = navController, startDestination = startingDestination) {
        composable(NavigationItem.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(NavigationItem.Detail.route) {
            DetailScreen(navController = navController)
        }
        composable(NavigationItem.Settings.route) {
            SettingsScreen(navController = navController)
        }
    }
}