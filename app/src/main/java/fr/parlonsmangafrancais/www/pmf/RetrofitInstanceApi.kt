package fr.parlonsmangafrancais.www.pmf

import android.support.compat.R.id.info
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.Response
import retrofit2.converter.moshi.MoshiConverterFactory

public class RetrofitInstanceApi {

    private val url = "http://www.parlonsmangafrancais.fr/wp-json/wp/v2/"

        val retrofit = Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()


    val service = retrofit.create(GetDataService::class.java)





}
