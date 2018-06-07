package fr.parlonsmangafrancais.www.pmf

import com.squareup.moshi.Json



// MANGA.KT = ADAPTER ( contient et duplique vue ) + VIEWHOLDER (vue )






data class  Manga  (

        @Json(name = "id") val id: Int,

        @Json(name = "name") val name: String,

val status : String

)







