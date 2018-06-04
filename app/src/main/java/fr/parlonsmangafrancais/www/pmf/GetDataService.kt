package fr.parlonsmangafrancais.www.pmf

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*


interface GetDataService {


    @GET("/mangas_api")
    fun listMangas(): Call<List<Manga>>


    @GET("/mangas-api/id")
    fun requestid() : Call<List<Manga>>

   /*
 @GET("/2.0/?method=artist.getinfo")
    fun requestArtistInfo(@Query("mbid") id: String, @Query("lang") language: String): Call

    @GET("/2.0/?method=artist.gettopalbums")
    fun requestAlbums(@Query("mbid") id: String, @Query("artist") artist: String): Call;

    @GET("/2.0/?method=artist.getsimilar")
    fun requestSimilar(@Query("mbid") id: String): Call

    @GET("/2.0/?method=album.getInfo")
    fun requestAlbum(@Query("mbid") id: String): Call


*/

}


