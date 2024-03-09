package uz.abdurashidov.quranapp.data.remote.model.surahs

data class GetAllSurahsResponse(
    val code: Int,
    val `data`: List<Data>,
    val status: String
)