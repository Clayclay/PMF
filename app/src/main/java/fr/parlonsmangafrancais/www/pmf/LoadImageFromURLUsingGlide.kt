package fr.parlonsmangafrancais.www.pmf

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.LinearLayout
import com.bumptech.glide.Glide


class LoadImageFromURLUsingGlide : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.manga_image)

        val linearLayout = findViewById<LinearLayout>(R.id.linearLayout)

        val imageView = ImageView(this)
        Glide.with(this)

                .load("https://s3.amazonaws.com/appsdeveloperblog/Micky.jpg")
                .into(imageView)
        linearLayout.addView(imageView)
    }
}