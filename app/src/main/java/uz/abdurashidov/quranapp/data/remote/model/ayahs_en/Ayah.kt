package uz.abdurashidov.quranapp.data.remote.model.ayahs_en

data class Ayah(
    val hizbQuarter: Int,
    val juz: Int,
    val manzil: Int,
    val number: Int,
    val numberInSurah: Int,
    val page: Int,
    val ruku: Int,
    val sajda: Boolean,
    val text: String
)