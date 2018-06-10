package fr.parlonsmangafrancais.www.pmf

import android.media.Image
import com.squareup.moshi.Json



// MANGA.KT = ADAPTER ( contient et duplique vue ) + VIEWHOLDER (vue )






data class  Manga  (

        val id: Int,

        val status : String

)

    // for {     {


   // val title : List<Title> = listOf()


    /*  for  {   [
 val content: List<Content> = listOf(),*/

  //  val  meta_api : List<Meta_api> = listOf()

//    data class Query(val searchinfo: SearchInfo)



data class Title (
        val rendered : String)

/*data class Meta_api (
        @Json ( name = "wpcf-image-principale") val  imgprincipale : Image,
        @Json ( name = "wpcf-dessinateur") val  dessinateur : String,
        @Json ( name = "wpcf-scenariste") val  scenariste : String
)*/