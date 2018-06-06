package fr.parlonsmangafrancais.www.pmf



/* classe manga contient un recycler qui contient un adapter qui contient un viewholder
  *
  * viewholder est la vue unique,
  * l'adapter c'est l'objet qui contient la vue unique et qui la duplique, et
  *
  * le recycler est le contenant général*/



data class Manga  (

        val name : String = "",

        val id: Int

)



/*  data class Info(var seed: String,
                var results: Int,
                var page: Int,
                var version: String)

    data class Result(var gender: String,
                  var email: String,
                  var registered: String,
                  var dob: String,
                  var phone: String,
                  var cell: String)               */

