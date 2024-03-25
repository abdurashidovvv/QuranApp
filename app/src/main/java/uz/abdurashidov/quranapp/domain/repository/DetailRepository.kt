package uz.abdurashidov.quranapp.domain.repository

interface DetailRepository {
    suspend fun fetchKeys(surahNumber:Int): List<String>
    suspend fun fetchValues(surahNumber: Int): List<String>
}