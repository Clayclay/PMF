package fr.parlonsmangafrancais.www.pmf

import android.media.Image
import java.util.*

data class Manga  (val name : String = "", val id: Int =0 ) {

}

  //  data class VideoGame(val name: String, val publisher: String, var reviewScore: Int)
   // val game: VideoGame = VideoGame("Gears of War", "Epic Games", 8)

//game.component1() // name
//game.component2() // publisher
//game.component3() // reviewScore

//fun copy(name: String = this.name , id: Int = this.id ) = Manga(name, id)



fun main(args: Array<String>) {

    val manga= Manga( "Epic Games",1)

    val manga2 = Manga("hehe",2)




        val (name, id) = manga

        println(manga.name)
        println(manga.id)
        println(manga.toString())

    println(manga.component1())    //Will return name.
    println(manga.component2())    //Will return 1


val mangas = listOf<Manga>(manga,manga2)
    for ((name,id)in mangas){
        println("${name} a une id de ${id}")
    }

}

