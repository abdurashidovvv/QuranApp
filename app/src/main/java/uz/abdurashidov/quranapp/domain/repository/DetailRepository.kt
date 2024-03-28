package uz.abdurashidov.quranapp.domain.repository

import kotlinx.coroutines.flow.flow
import uz.abdurashidov.quranapp.data.remote.ApiService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DetailRepository @Inject constructor(
    private val apiService: ApiService,
) {
    suspend fun getAllSurahDetails(surahNumber: Int) =
        flow { emit(apiService.getAllSurahDetails(surahNumber)) }
}