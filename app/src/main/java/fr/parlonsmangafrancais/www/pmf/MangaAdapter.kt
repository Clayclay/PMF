package fr.parlonsmangafrancais.www.pmf

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

import com.bumptech.glide.Glide

import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.manga_layout.view.*
import com.bumptech.glide.load.resource.bitmap.TransformationUtils.centerCrop
import com.bumptech.glide.request.RequestOptions
import java.net.URL
import android.graphics.Bitmap




// L ADAPTATEUR POUR TRANSMETTRE DU JSON A MANGA.KT
// adapter = objet qui contient vue unique et la duplique

class MangaAdapter(

        private val mangaList: List<Manga>,
        private val listener: (Manga) -> Unit



): RecyclerView.Adapter<MangaAdapter.MangaHolder>() {

    // method call when the presenter view is created
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MangaHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.manga_layout, parent, false))

    // Pour les datas


    override fun onBindViewHolder(holder: MangaHolder, position: Int) = holder.bind(  mangaList[position]  ,listener     )


    //Pour la taille
    override fun getItemCount() = mangaList.size



    // Quoi afficher / The ViewHolder of the adapter




    class MangaHolder(mangaView: View): RecyclerView.ViewHolder(mangaView) {

        fun bind(   manga: Manga,    listener: (Manga) -> Unit) = with(itemView)
          {

// Vue = champ / Binds a post into the view  ex : slug.text = manga.slug
            title.text = manga.title?.rendered
            categories.text = manga.categoriesAPI.toString()
            // styles.text = manga.stylesAPI?.toString()
            styles.text = manga.stylesAPI.component1().toString()

          /* manga.stylesAPI.forEach {
                println(it)
            }*/

           editeurs.text = manga.editeursMangasAPI.toString()

/* Afficher le nom correspondant
        nbtome.text = manga.nbtomeAPI.component1().toString()*/

            println( manga.nbtomeAPI.component1().toString())


            var tomenbr = manga.nbtomeAPI.component1().toInt()

           /* if( tomenbr === tome.id.toInt())
            {
                println(tomenbr)
                println( tome.name)
        }*/

////////////////* Afficher L'image du Manga */////////////////////

println(manga.metaAPI["wpcf-image-principale"])

              val imageView = findViewById(R.id.imageMangaView) as ImageView

              val imgURL =  manga.metaAPI["wpcf-image-principale"].toString()

              // A besoin de " imgURL"

              Glide.with(context)
                      .load(imgURL)

                      .into(imageView)



            setOnClickListener { listener(manga) }

        }
    }
}



















