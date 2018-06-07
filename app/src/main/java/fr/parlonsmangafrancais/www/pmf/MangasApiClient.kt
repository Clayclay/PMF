package fr.parlonsmangafrancais.www.pmf


import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.*

interface MangasApiClient {

    // L API POUR RECUPERER LE JSON ET SES DONNEES


    /* Get list of Mangas */
    @GET("mangas_api")
    fun getMangas(): Observable<List<Manga>>

    /* Get one Manga by it's id */
    @GET("mangas_api/{id}")
    fun getManga(@Path("id") id: Int): Observable<Manga>

    /* Add new Manga */
    @Headers("Content-Type: application/json;charset=utf-8")
    @POST("mangas_api")
    fun addManga(@Body manga: Manga): Observable<Manga>

    companion object {

        fun create(): MangasApiClient {

            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(MoshiConverterFactory.create())
                    .baseUrl("http://www.parlonsmangafrancais.fr/wp-json/wp/v2/mangas-api/")
                    .build()

            return retrofit.create(MangasApiClient::class.java)

        }
    }

}