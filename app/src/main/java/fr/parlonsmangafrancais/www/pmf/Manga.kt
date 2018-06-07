package fr.parlonsmangafrancais.www.pmf

import com.squareup.moshi.Json


/* classe manga contient un recycler qui contient un adapter qui contient un viewholder
  *
  * viewholder est la vue unique,
  * l'adapter c'est l'objet qui contient la vue unique et qui la duplique, et
  *
  * le recycler est le contenant général
  *
  *
  *
  * */



data class  Manga  (

        @Json(name = "id") val id: Int,

        @Json(name = "name") val name: String

)

data class Result (val items: List<Manga>)





