package uz.abdurashidov.quranapp.data.remote.model.ayahs_ar

data class Data(
    val ayahs: List<Ayah>,
    val edition: Edition,
    val englishName: String,
    val englishNameTranslation: String,
    val name: String,
    val number: Int,
    val numberOfAyahs: Int,
    val revelationType: String
)