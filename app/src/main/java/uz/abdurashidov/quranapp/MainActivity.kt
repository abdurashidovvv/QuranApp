package uz.abdurashidov.quranapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import cafe.adriel.voyager.navigator.Navigator
import dagger.hilt.android.AndroidEntryPoint
import uz.abdurashidov.quranapp.presentation.detail.DetailScreenViewModel
import uz.abdurashidov.quranapp.presentation.home.HomeScreen
import uz.abdurashidov.quranapp.presentation.home.HomeScreenViewModel
import uz.abdurashidov.quranapp.presentation.navigation.AppNavHost
import uz.abdurashidov.quranapp.presentation.theme.QuranAppTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    val homeScreenViewModel by viewModels<HomeScreenViewModel>()
    val detailScreenViewModel by viewModels<DetailScreenViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            QuranAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    AppNavHost(
                        modifier = Modifier.fillMaxSize(),
                        navController = navController,
                        homeScreenViewModel = homeScreenViewModel,
                        detailScreenViewModel = detailScreenViewModel
                    )
                }
            }
        }
    }
}

/*
https://al-quran-api-three.vercel.app/quran/1
* */
