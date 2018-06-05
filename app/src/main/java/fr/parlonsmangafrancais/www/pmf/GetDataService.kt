package fr.parlonsmangafrancais.www.pmf


import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.*
import io.reactivex.Observable


interface GetDataService {

    /* API CLIENT */



    /* Get list of articles */
    @GET("mangas_api")
    fun getMangas(): Observable<List<Manga>>

    /* Get one article by it's id */
    @GET("mangas_api/{id}")
    fun getManga(@Path("id") id: Int): Observable<Manga>

    /* Add new article */
    @Headers("Content-Type: application/json;charset=utf-8")
    @POST("posts")
    fun addManga(@Body manga: Manga): Observable<Manga>

  /*  @GET("/mangas_api")
       fun getManga(@Path("manga") username: String): Call<Manga>

    @GET("/mangas-api/id")
     fun idList(@Path("id") groupId: Int, @Query("id") sort: String): Call<List<Manga>>*/


    companion object {

        fun create(): GetDataService {

            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(MoshiConverterFactory.create())
                    .baseUrl("http://www.parlonsmangafrancais.fr/wp-json/wp/v2/")
                    .build()

            return retrofit.create(GetDataService::class.java)

        }
    }
}


