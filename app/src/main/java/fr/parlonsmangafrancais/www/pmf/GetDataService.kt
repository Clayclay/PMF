package fr.parlonsmangafrancais.www.pmf

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


interface GetDataService {


    @GET("/2.0/mangas_api")
    fun listMangas(): Call<List<Manga>>

   /*

    @GET("/2.0/?method=artist.gettopalbums")
    fun requestAlbums(@Query("mbid") id: String, @Query("artist") artist: String): Call;


*/

}


