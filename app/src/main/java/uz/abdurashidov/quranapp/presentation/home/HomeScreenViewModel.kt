package uz.abdurashidov.quranapp.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import uz.abdurashidov.quranapp.data.remote.model.surahs.GetAllSurahsResponse
import uz.abdurashidov.quranapp.domain.repository.QuranRepository
import javax.inject.Inject


@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val quranRepository: QuranRepository
) : ViewModel() {

    private val _allQuranSurahs = MutableStateFlow<State>(State())
    val allQuranSurahs: StateFlow<State> get() = _allQuranSurahs.asStateFlow()

    init {
        viewModelScope.launch {
            try {
                quranRepository.getAllSurahs().collectLatest {
                    _allQuranSurahs.value = State(surahs = it.body())
                }
            } catch (e: Exception) {

            }
        }
    }
}

data class State(
    var surahs: GetAllSurahsResponse? = null
)