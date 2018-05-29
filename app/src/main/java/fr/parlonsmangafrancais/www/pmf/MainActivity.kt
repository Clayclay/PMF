package fr.parlonsmangafrancais.www.pmf

import android.annotation.SuppressLint
import android.content.Intent

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import android.widget.Toast


import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Instead of findViewById<TextView>(R.id.textView)
        textView.setText("Hello,Marie!")

//step 2
        val manga1 = Manga("manga nom")
        manga1.resume = "resume ici"
        manga1.imageUrl
        //manga1.dateFutur
        manga1.note





        mangaName.setText(manga1.name)

//step 3 button test


        button1.setOnClickListener {


            Toast.makeText(this@MainActivity, "You clicked me.", Toast.LENGTH_SHORT).show()


            val intent = Intent( this ,LoadImageFromURLUsingGlide::class.java)
            startActivity(intent);



        }


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
