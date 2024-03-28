package uz.abdurashidov.quranapp.presentation.detail

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import uz.abdurashidov.quranapp.data.remote.model.alldata.GetAllSurahDetailsResponse
import uz.abdurashidov.quranapp.domain.repository.DetailRepository
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class DetailScreenViewModel @Inject constructor(
    private val detailRepository: DetailRepository,
) : ViewModel() {
    private val _ayahs = MutableStateFlow<GetAllSurahDetailsResponse?>(null)
    val ayahs: MutableStateFlow<GetAllSurahDetailsResponse?> = _ayahs

    fun getAllSurahDetails(surahNumber: Int) = viewModelScope.launch {
        try {
            detailRepository.getAllSurahDetails(surahNumber).collectLatest {
                if (it.isSuccessful) {
                    _ayahs.value = it.body()
                }
            }
        } catch (e: Exception) {
            Log.d("DetailScreenException", "getAllSurahDetails: ${e.message}")
        }
    }
}

