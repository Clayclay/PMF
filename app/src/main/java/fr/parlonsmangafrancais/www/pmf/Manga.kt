package fr.parlonsmangafrancais.www.pmf

import android.media.Image
import com.squareup.moshi.Json




// MANGA.KT = ADAPTER ( contient et duplique vue ) + VIEWHOLDER (vue )


data class  Manga  (

        val id: Long? ,
        val status: String? = null,
        val type: String? = null,

        val slug: String? = null,

        @Json(name = "categories_api")
        val categoriesAPI: List<Long>,


        @Json(name = "styles_api")
        val stylesAPI: List<Long> ,

        @Json(name = "editeurs_mangas_api")
        val editeursMangasAPI: List<Long>,

        @Json(name = "nbtome_api")
        val nbtomeAPI: List<Long>,

        @Json(name = "Meta_api")
        val metaAPI: Map<String, List<String>>,

        val title: Title? = null,

        val tome : Tome? = null


)


data class Title (
        val rendered: String
)

data class Tome (
        val id: Long,
        val name: String
)