package fr.parlonsmangafrancais.www.pmf

import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET



interface MangasApiClient {

    /* Get list of Mangas*/
    @GET("mangas-api")
    
    fun getMangas(): Observable<List<Manga>>


    @GET("nbtome_api")
    fun getTomes(): Observable<List<Tome>>

    val TomesList =create().flatMap { ( Tomes) -> listOf(tomes) }
    val MangasList = create().flatMap { (Mangas) -> listOf(mangas) }
    val  getMetT() =  create()  .{ mangas,tomes ->  listOf(mangas) }
    }


    companion object {
        fun create(): MangasApiClient {

            val url = "https://www.parlonsmangafrancais.fr/wp-json/wp/v2/"

            val retrofit = Retrofit.Builder()

                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(MoshiConverterFactory.create())
                    .baseUrl(url)
                    .build()

            return retrofit.create(MangasApiClient::class.java)
        }




    }

    
}







