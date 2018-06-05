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

    var disposable: Disposable? = null


    /*  Le COMPAGNON OBJECT */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_manga)



      /*  override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)*/

            // Uncomment to show list of articles in Logcat
            //showMangas()

            // Uncomment to show article with id=1 in Logcat
            //showManga(1)

            // Test post request and add new article

            val mangatest = Manga( "Have fun posting", id = 1)
        postManga(mangatest)

            //postArticle(article)

        }

        // GET List of Articles
        private fun showMangas() {

            disposable = client.getMangas()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                            { result -> Log.v("MANGAS", "" + result) },
                            { error -> Log.e("ERROR", error.message) }
                    )

        }

        // GET Article by id
        private fun showManga(id: Int) {

            disposable = client.getManga(id)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                            { result -> Log.v("ARTICLE ID ${id}: ", "" + result) },
                            { error -> Log.e("ERROR", error.message) }
                    )

        }

        // POST new Article
        private fun postManga(manga: Manga) {

            disposable = client.addManga(manga)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                            { result -> Log.v("POSTED ARTICLE", "" + manga ) },
                            { error -> Log.e("ERROR", error.message ) }
                    )
        }

        override fun onPause() {
            super.onPause()
            disposable?.dispose()
        }

}



















