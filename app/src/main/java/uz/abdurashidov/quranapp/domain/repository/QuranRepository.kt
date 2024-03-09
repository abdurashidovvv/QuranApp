package uz.abdurashidov.quranapp.domain.repository

import kotlinx.coroutines.flow.flow
import uz.abdurashidov.quranapp.data.remote.ApiService
import javax.inject.Inject

class QuranRepository @Inject constructor(
    private val apiService: ApiService
) {

    suspend fun getAllSurahs() = flow { emit(apiService.getAllSurahs()) }
    suspend fun getAllAyahs(surahNumber: Int) =
        flow { emit(apiService.getAyahsBySurahNumber(surahNumber)) }
    suspend fun getAllAyahsTranslation(surahNumber: Int) =
        flow { emit(apiService.getAyahsTranslationBySurahNumber(surahNumber)) }
}