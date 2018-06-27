package fr.parlonsmangafrancais.www.pmf


import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers



class ActivityManga : AppCompatActivity() {

    val client by lazy {
        MangasApiClient.create()

    }

    var disposable: Disposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manga)

        showMangas()
    }

  /*  // GET List of Tomes
    private fun showTomes() {   disposable= client.getTomes()    .subscribeOn(Schedulers.io())   .observeOn(AndroidSchedulers.mainThread())
                .subscribe(    { result -> Log.v("TOMES", "" + result )}      // { result -> setupRecycler(result )}
                )    }*/

    // GET List of Articles //=viewAdapter = MyAdapter(myDataset) ==MangaAdapter

    fun showMangas(){

        client.getMangas()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())

              // .flatMap {client.getTomes() .subscribeOn(Schedulers.io())   }

               //.flatMap(mangas: Observable<T>, function: (T) -> ObservableSource<R1>): Any {        }

                .flatMap{
                    client.getMangas().subscribeOn(Schedulers.io())
                    client.getTomes() .subscribeOn(Schedulers.io())

                       call(Manga manga) {
                       return manga.appelAsynchrone3 (getMangas())
                    }



                 .subscribe(
                        { result ->  setupRecycler(result) },
                         { error -> Log.e("ERROR", error.message) },
                        { Log.v("TAG", "Chains Completed") }



                        )

    }



/*  private fun showMangas() {

       disposable = client
               .getMangas()

               //.loadMangas()
               .subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread())
               .subscribe(
                       { result -> setupRecycler(result)
                          // doSomethingWithItems(result.data)
                         },
                       { error -> Log.e("ERROR", error.message) },
                       { Log.v("TAG", "Chains Completed") }
               )
   }*/


    // LE RECYCLER ( contenant general )POUR LA VUE

    fun setupRecycler( mangaList: List<Manga>   ) {

        mangas_recycler.setHasFixedSize(true)

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        mangas_recycler.layoutManager = layoutManager

       mangas_recycler.adapter = MangaAdapter(mangaList  ){
            Log.v("Manga", it.toString())        }



    }


    //////////////////////////////////////////////////////////////////////
    override fun onPause() {
        super.onPause()
        disposable?.dispose()
    }
}




