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
import cafe.adriel.voyager.navigator.Navigator
import dagger.hilt.android.AndroidEntryPoint
import uz.abdurashidov.quranapp.presentation.home.HomeScreen
import uz.abdurashidov.quranapp.presentation.home.HomeScreenViewModel
import uz.abdurashidov.quranapp.presentation.theme.QuranAppTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    val homeScreenViewModel by viewModels<HomeScreenViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            QuranAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    
                    val list = homeScreenViewModel.allQuranSurahs.collectAsState().value
                    Log.d("AllData", "onCreate: $list")
                    HomeScreen(homeScreenViewModel)
                }
            }
        }
    }
}
