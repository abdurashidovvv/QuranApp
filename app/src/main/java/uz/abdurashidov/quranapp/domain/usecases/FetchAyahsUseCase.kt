package uz.abdurashidov.quranapp.domain.usecases

import uz.abdurashidov.quranapp.domain.repository.DetailRepository
import javax.inject.Inject

class FetchAyahsUseCase @Inject constructor(
    private val repository: DetailRepository
) {
    suspend operator fun invoke(surahNumber: Int): Pair<List<String>, List<String>> {
        val keys = repository.fetchKeys(surahNumber = surahNumber)
        val values = repository.fetchValues(surahNumber = surahNumber)
        return keys to values
    }
}