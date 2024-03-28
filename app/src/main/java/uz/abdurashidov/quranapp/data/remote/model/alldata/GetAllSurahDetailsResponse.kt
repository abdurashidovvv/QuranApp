package uz.abdurashidov.quranapp.data.remote.model.alldata

data class GetAllSurahDetailsResponse(
    val code: Int,
    val `data`: List<Data>,
    val status: String
)