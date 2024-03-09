package uz.abdurashidov.quranapp.data.remote.model.surahs

data class Data(
    val englishName: String,
    val englishNameTranslation: String,
    val name: String,
    val number: Int,
    val numberOfAyahs: Int,
    val revelationType: String
)