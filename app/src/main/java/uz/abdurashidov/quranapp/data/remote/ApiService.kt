package uz.abdurashidov.quranapp.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import uz.abdurashidov.quranapp.data.remote.model.ayahs_ar.GetAllAyahsResponse
import uz.abdurashidov.quranapp.data.remote.model.ayahs_en.GetAllAyahsTranlationResponse
import uz.abdurashidov.quranapp.data.remote.model.surahs.GetAllSurahsResponse


interface ApiService {

    @GET("surah/")
    suspend fun getAllSurahs(): Response<GetAllSurahsResponse>

    @GET("surah/{surahNumber}/ar.alafasy")
    suspend fun getAyahsBySurahNumber(
        @Path("surahNumber") number: Int
    ): Response<GetAllAyahsResponse>

    @GET("surah/{surahNumber}/en.asad")
    suspend fun getAyahsTranslationBySurahNumber(
        @Path("surahNumber") number: Int
    ): Response<GetAllAyahsTranlationResponse>

}

//https://alquran.cloud/api#collapseFour