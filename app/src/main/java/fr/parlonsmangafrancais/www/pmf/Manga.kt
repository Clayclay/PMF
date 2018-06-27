package fr.parlonsmangafrancais.www.pmf

import com.squareup.moshi.Json
import java.util.*


// MANGA.KT = ADAPTER ( contient et duplique vue ) + VIEWHOLDER (vue )


data class  Manga  (

        val id: UUID ,
        val status: String? = null,
        val type: String? = null,

        val slug: String? = null,

        @Json(name = "categories_api")
        val categoriesAPI: List<Long>?= null,


        @Json(name = "styles_api")
        val stylesAPI: List<Long>?= null ,

        @Json(name = "editeurs_mangas_api")
        val editeursMangasAPI: List<Long>?= null,

        @Json(name = "nbtome_api")
        val nbtomeAPI: List<Long>?= null,

        @Json(name = "Meta_api")
        val metaAPI: Map<String, List<String>>?= null,

        val title: Title? = null,

        val tome : Tome? = null


)


data class Title (
        val rendered: String
)

data class Tome  (
        val id: Long,
        val name: String


)



data class ExtendedManga(val manga : Manga , val tome: Tome)