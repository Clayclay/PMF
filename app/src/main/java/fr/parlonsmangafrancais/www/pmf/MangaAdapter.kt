package fr.parlonsmangafrancais.www.pmf


import android.graphics.Paint
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import com.beust.klaxon.JsonArray

import com.bumptech.glide.Glide
import io.reactivex.Observable

import kotlinx.android.synthetic.main.manga_layout.view.*


// L ADAPTATEUR POUR TRANSMETTRE DU JSON A MANGA.KT
// adapter = objet qui contient vue unique et la duplique

class MangaAdapter(        private val mangaList: List<Manga>,        private val listener: (Manga) -> Unit
): RecyclerView.Adapter<MangaAdapter.MangaHolder>() {


    // method call when the presenter view is created
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MangaHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.manga_layout, parent, false))

    // Pour les datas

    override fun onBindViewHolder(holder: MangaHolder, position: Int) = holder.bind(
            mangaList[position], listener
    )

    //Pour la taille
    override fun getItemCount() = mangaList.size


        // Quoi afficher / The ViewHolder of the adapter

        class MangaHolder(mangaView: View) : RecyclerView.ViewHolder(mangaView) {


            fun bind(manga: Manga, listener: (Manga) -> Unit) = with(itemView)
            {


                ////////////////* Afficher L'image du Manga *////////////////////////////

                val imageView = findViewById(R.id.imageMangaView) as ImageView
                val imgURL = manga.metaAPI!!["wpcf-image-principale"]!!.component1().toString()

                Glide.with(this)
                        .load(imgURL)
                        .into(imageView)

                ////////////////////////////////////////////////////////////////////////

                title.text = manga.title?.rendered


                ////////////////* Date a Ameliorer *////////////////////////////
                datefutur.text = manga.metaAPI["datefutur"]?.component1().toString()
                ////////////////////////////////////////////////////////////////

                categories.text = manga.categoriesAPI.toString()
                editeurs.text = manga.editeursMangasAPI.toString()

                styles.text = manga.stylesAPI.toString()

               // println(manga.stylesAPI)
              //  println(manga.nbtomeAPI.toString())
               // println(manga.tome?.name)

                nbtome.text = manga.nbtomeAPI.toString()

               // tomename.text = manga.tome?.name

                setOnClickListener { listener(manga) }

            }


        }
    }



















