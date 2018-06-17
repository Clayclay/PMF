package fr.parlonsmangafrancais.www.pmf

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager

import android.util.Log

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


import kotlinx.android.synthetic.main.activity_manga.*
import kotlinx.android.synthetic.main.manga_layout.*


class ActivityManga : AppCompatActivity() {


    val client by lazy {
        MangasApiClient.create()
    }

    var disposable: Disposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manga)

        // LE COMPAGNON OBJET ?!

        // Uncomment to show list of articles in Logcat
        showMangas()



        /*  // Test post request and add new article*/
        /*  showManga(1)
             val manga = Manga(1, "Have fun posting")
             postManga(manga)
        */


    }

    // GET List of Articles
   private fun showMangas() {
//créer la requête GET :
        disposable = client.getMangas( )

                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { result -> setupRecycler(result) },
                        { error -> Log.e("ERROR", error.message) }
                )

    }
    // GET List of Tomes

   /* private fun showTomes() {
 disposable= client.getTomes()
         .subscribeOn(Schedulers.io())
         .observeOn(AndroidSchedulers.mainThread())
         .subscribe(
                //{ result -> Log.v("TOMES", "" + result ) }
                { result -> setupRecycler(result ) }
         )
    }*/




    // GET Article by id
    private fun showManga(id: Int) {

        disposable = client.getManga(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { result -> Log.v("MANGA ID ${id}: ", "" + result) },
                        { error -> Log.e("ERROR", error.message) }
                )

    }

    // POST new Article
 /* private fun postManga(manga: Manga) {

        disposable = client.addManga(manga)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { result -> Log.v("POSTEDMANGA", "" + manga ) },
                        { error -> Log.e("ERROR", error.message ) }
                )
    }*/




    // LE RECYCLER ( contenant general )POUR LA VUE

    fun setupRecycler( mangaList: List<Manga>  ) {
        mangas_recycler.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        mangas_recycler.layoutManager = layoutManager

       mangas_recycler.adapter = MangaAdapter(mangaList   ){
            Log.v("Manga", it.toString())        }
    }




    override fun onPause() {
        super.onPause()
        disposable?.dispose()
    }












// important


}





