package uz.abdurashidov.quranapp.presentation.detail

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import uz.abdurashidov.quranapp.data.remote.model.ayahs_ar.Data
import uz.abdurashidov.quranapp.domain.repository.QuranRepository
import javax.inject.Inject

@HiltViewModel
class DetailScreenViewModel @Inject constructor(
    private val quranRepository: QuranRepository
) : ViewModel() {

    private val _allQuranAyahs = MutableStateFlow<Data?>(null)
    val allQuranAyahs: StateFlow<Data?> get() = _allQuranAyahs.asStateFlow()
    fun getAllQuranAyahs(surahNumber: Int) {
        viewModelScope.launch {
            quranRepository.getAllAyahs(surahNumber = surahNumber).collectLatest {
                if (it.isSuccessful) {
                    _allQuranAyahs.value = it.body()!!.data
                }
            }
        }
    }

    private val _allQuranAyahsTranslation = MutableStateFlow<uz.abdurashidov.quranapp.data.remote.model.ayahs_en.Data?>(null)
    val allQuranAyahsTranslation: StateFlow<uz.abdurashidov.quranapp.data.remote.model.ayahs_en.Data?> get() = _allQuranAyahsTranslation.asStateFlow()

    fun getAllQuranAyahsInEnglish(surahNumber: Int){
        viewModelScope.launch {
            quranRepository.getAllAyahsTranslation(surahNumber = surahNumber).collectLatest {
                if (it.isSuccessful) {
                    _allQuranAyahsTranslation.value = it.body()!!.data
                }
            }
        }
    }
}