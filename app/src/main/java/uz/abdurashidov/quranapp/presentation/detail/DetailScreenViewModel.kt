package uz.abdurashidov.quranapp.presentation.detail

import android.util.Log
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
import uz.abdurashidov.quranapp.domain.usecases.FetchAyahsUseCase
import javax.inject.Inject

@HiltViewModel
class DetailScreenViewModel @Inject constructor(
    private val fetchAyahsUseCase: FetchAyahsUseCase,
) : ViewModel() {
    private val _keys = MutableStateFlow<List<String>>(emptyList())
    val keys: StateFlow<List<String>> = _keys

    private val _values = MutableStateFlow<List<String>>(emptyList())
    val values: StateFlow<List<String>> = _values

    fun fetchAyahs(surahNumber: Int) {
        viewModelScope.launch {
            val (fetchedKeys, fetchedValues) = fetchAyahsUseCase(surahNumber = surahNumber)
            _keys.value = fetchedKeys
            _values.value = fetchedValues
        }
    }


}