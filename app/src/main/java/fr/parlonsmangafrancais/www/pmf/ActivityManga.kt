package fr.parlonsmangafrancais.www.pmf

import android.os.Bundle
import android.support.v7.app.AppCompatActivity



import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers



class ActivityManga : AppCompatActivity() {



    val client by lazy {
        GetDataService.create()
    }

    // variable jetable
    var disposable: Disposable? = null

 // Initializing an empty ArrayList to be filled with animals
 //val mangas: ArrayList<String> = ArrayList()


    /*  Le COMPAGNON OBJECT */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_manga)


        // Loads animals into the ArrayList
        //addMangas()

     /*   val addManga = GetDataService.create()
       val test =  addManga.getManga(2507)*/


        // Test post request and add new article
        val manga = Manga (1 , "test")

        postManga(manga)



        /* You can use GridLayoutManager if you want multiple columns. Enter the number of columns as a parameter.
        rv_list_manga.layoutManager = LinearLayoutManager(this)

        // You can use GridLayoutManager if you want multiple columns. Enter the number of columns as a parameter.
        //  rv_animal_list.layoutManager = GridLayoutManager(this, 2)


        // Access the RecyclerView Adapter and load the data into it
     rv_list_manga.adapter = MangaAdapter(mangas ,this)*/

    }





 /*fun addMangas() {     mangas.add("cat")
     mangas.add("tiger") }*/



    // GET List of Articles
    private fun showMangas() {

        disposable = client.getMangas()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { result -> Log.v("Mangas", "" + result) },
                        { error -> Log.e("ERROR", error.message) }
                )

    }

    // GET Article by id
    private fun showManga(id: Int) {

        disposable = client.getManga(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { result -> Log.v("Manga ID ${id}: ", "" + result) },
                        { error -> Log.e("ERROR", error.message) }
                )

    }

    // POST new Article
    private fun postManga(Manga: Manga) {

        disposable = client.addManga(Manga)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { result -> Log.v("POSTED Manga", "" + Manga ) },
                        { error -> Log.e("ERROR", error.message ) }
                )
    }

    override fun onPause() {
        super.onPause()
        disposable?.dispose()
    }










}


















