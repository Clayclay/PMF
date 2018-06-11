package fr.parlonsmangafrancais.www.pmf

import android.media.Image
import com.squareup.moshi.Json



// MANGA.KT = ADAPTER ( contient et duplique vue ) + VIEWHOLDER (vue )


data class  Manga  (

        val id: Long? ,
        val status: String? = null,
        val type: String? = null,

        //

        val slug: String? = null,
        val title: Title? = null,



        val tome: Tome? = null,


        @Json(name = "categories_api")
        val categoriesAPI: List<Long>,


        @Json(name = "styles_api")
        val stylesAPI: List<Long> ,

        @Json(name = "editeurs_mangas_api")
        val editeursMangasAPI: List<Long>,

        @Json(name = "nbtome_api")
        val nbtomeAPI: List<Long>,

        @Json(name = "Meta_api")
        val metaAPI: Map<String, List<String>>? = null
) {}


data class Title (
        val rendered: String
)







/*data class metaAPI (
        @Json(name = "wpcf-statut")
        val status: String? = null,

        @Json(name = "wpcf-date-de-sortie")
        val dateSortie: String? = null,

        @Json(name = "wpcf-resume")
        val resume: String? = null

         @Json(name = "wpcf-image-principale")
        val imgURL: String? = null


)
class MetaAPI(elements: Map<String, List<String>>) : HashMap<String, List<String>>(elements) {
    public fun toJson() = klawon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = MetaAPI (
                klaxon.parseJsonObject(java.io.StringReader(json)) as Map<String, List<String>>
        )
    }
}
*/
