package uz.abdurashidov.quranapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import uz.abdurashidov.quranapp.presentation.detail.DetailScreen
import uz.abdurashidov.quranapp.presentation.detail.DetailScreenViewModel
import uz.abdurashidov.quranapp.presentation.home.HomeScreen
import uz.abdurashidov.quranapp.presentation.home.HomeScreenViewModel
import uz.abdurashidov.quranapp.presentation.settings.SettingsScreen

@Composable
fun AppNavHost(
    modifier: Modifier,
    navController: NavHostController,
    startingDestination: String = NavigationItem.Home.route,
    homeScreenViewModel: HomeScreenViewModel,
    detailScreenViewModel: DetailScreenViewModel
) {
    NavHost(navController = navController, startDestination = startingDestination) {
        composable(NavigationItem.Home.route) {
            HomeScreen(navController = navController, homeScreenViewModel = homeScreenViewModel)
        }
        composable(
            route = NavigationItem.Detail.route + "/{argument}",
            arguments = listOf(navArgument("argument") { type = NavType.IntType })
        ) { backStackEntry ->
            DetailScreen(
                navController = navController,
                argument = backStackEntry.arguments?.getInt("argument"),
                detailScreenViewModel = detailScreenViewModel
            )
        }
        composable(NavigationItem.Settings.route) {
            SettingsScreen(navController = navController)
        }
    }
}