package uz.abdurashidov.quranapp.presentation.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import uz.abdurashidov.quranapp.data.remote.model.surahs.Data
import uz.abdurashidov.quranapp.data.remote.model.surahs.GetAllSurahsResponse
import uz.abdurashidov.quranapp.domain.repository.QuranRepository
import javax.inject.Inject


@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val quranRepository: QuranRepository
) : ViewModel() {

    private val _allQuranSurahs = MutableStateFlow<List<Data>>(emptyList())
    val allQuranSurahs: StateFlow<List<Data>> get() = _allQuranSurahs.asStateFlow()

    init {
        viewModelScope.launch {
            try {
                quranRepository.getAllSurahs().collectLatest {
                    Log.d("CheckingData", "$it")
                    if (it.isSuccessful){
                        _allQuranSurahs.value = it.body()!!.data
                    }
                }
            } catch (e: Exception) {
                Log.d("CheckingData", "$e")
            }
        }
    }
}
