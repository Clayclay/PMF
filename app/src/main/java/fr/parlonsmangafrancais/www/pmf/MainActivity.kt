package fr.parlonsmangafrancais.www.pmf

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*





class MainActivity : AppCompatActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        // Instead of findViewById<TextView>(R.id.textView)
        textView.setText("Hello,Marie!")

//step 2
val manga1 = Manga("Marie")
        manga1.resume = "resume ici"
        manga1.imageManga
        manga1.dateFutur
        manga1.note

mangaName.setText(manga1.name)

    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String



    companion object {

        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }





}
