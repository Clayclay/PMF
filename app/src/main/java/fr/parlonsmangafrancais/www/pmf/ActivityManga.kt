package fr.parlonsmangafrancais.www.pmf

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager

import kotlinx.android.synthetic.main.list_manga.*


class ActivityManga : AppCompatActivity() {

    // Initializing an empty ArrayList to be filled with animals

    val mangas: ArrayList<String> = ArrayList()


    /*  Le COMPAGNON OBJECT */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_manga)


        // Loads animals into the ArrayList
        addMangas()


        // You can use GridLayoutManager if you want multiple columns. Enter the number of columns as a parameter.
        rv_list_manga.layoutManager = LinearLayoutManager(this)

        // You can use GridLayoutManager if you want multiple columns. Enter the number of columns as a parameter.
//        rv_animal_list.layoutManager = GridLayoutManager(this, 2)


        // Access the RecyclerView Adapter and load the data into it
       rv_list_manga.adapter = MangaAdapter(mangas, this)

    }



    fun addMangas() {
        mangas.add("dog")



    }
}


















