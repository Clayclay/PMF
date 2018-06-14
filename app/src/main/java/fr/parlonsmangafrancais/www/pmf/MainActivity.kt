package fr.parlonsmangafrancais.www.pmf

import android.annotation.SuppressLint
import android.content.Intent

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import android.widget.Toast
import fr.parlonsmangafrancais.www.pmf.R.id.*


import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Instead of findViewById<TextView>(R.id.textView)
            textView.setText("Bienvenue")





        // button manga


        button_manga.setOnClickListener {


            val intent = Intent( this ,ActivityManga::class.java)
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
