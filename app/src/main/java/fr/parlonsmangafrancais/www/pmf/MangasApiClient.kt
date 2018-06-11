package fr.parlonsmangafrancais.www.pmf


import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.*



interface MangasApiClient {

    // L API POUR RECUPERER LE JSON ET SES DONNEES
//  l’interface Kotlin qui va contenir la déclaration de toutes les requêtes disponibles

    /* Get list of Mangas*/
    @GET("mangas-api")
    fun getMangas()
            : Observable<List<Manga>>



    /* Get one Manga by it's id*/
    @GET("mangas-api/{id}")
    fun getManga(@Path("id") id: Int): Observable<Manga>

    /* Add new Manga*/
    @Headers("Content-Type: application/json;charset=utf-8")
    @POST("mangas-api")
    fun addManga(@Body manga: Manga): Observable<Manga>


/* Deuxieme Partie*/

    // Recuperer les termes nb_tomes

    @GET("nbtome-api")
    fun getTomes()
            : Observable<List<Tome>>



    companion object {

// nous allons créer une instance de client Retrofit.
        fun create(): MangasApiClient {

           val url = "https://www.parlonsmangafrancais.fr/wp-json/wp/v2/"



            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(MoshiConverterFactory.create())
                    .baseUrl(url)
                    .build()

//l’instance du service
            return retrofit.create(MangasApiClient::class.java)

        }
    }

}