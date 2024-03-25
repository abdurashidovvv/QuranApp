package uz.abdurashidov.quranapp.data.remote.repository

import uz.abdurashidov.quranapp.data.remote.ApiService
import uz.abdurashidov.quranapp.domain.repository.DetailRepository
import javax.inject.Inject

class DetailRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
) : DetailRepository {
    override suspend fun fetchKeys(surahNumber: Int): List<String> {
        val ayahAr = ArrayList<String>()
        apiService.getAyahsBySurahNumber(number = surahNumber).body()!!.data.ayahs.forEach { ayah ->
            ayahAr.add(ayah.text)
        }
        return ayahAr
    }

    override suspend fun fetchValues(surahNumber: Int): List<String> {
        val ayahEng = ArrayList<String>()
        apiService.getAyahsTranslationBySurahNumber(number = surahNumber)
            .body()!!.data.ayahs.forEach { ayah ->
            ayahEng.add(ayah.text)
        }
        return ayahEng
    }
}
