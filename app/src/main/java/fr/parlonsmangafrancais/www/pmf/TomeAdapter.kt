package fr.parlonsmangafrancais.www.pmf

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.manga_layout.view.*
import kotlinx.android.synthetic.main.tome_list.view.*


// L ADAPTATEUR POUR TRANSMETTRE DU JSON A MANGA.KT
// adapter = objet qui contient vue unique et la duplique

class TomeAdapter(        private val tomeList: List<Tome>,        private val listener: (Tome) -> Unit
): RecyclerView.Adapter<TomeAdapter.TomeHolder>() {


    // method call when the presenter view is created
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = TomeHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.tome_list, parent, false))

    // Pour les datas

    override fun onBindViewHolder(holder: TomeHolder, position: Int) = holder.bind(
            tomeList[position], listener

    )

    //Pour la taille
    override fun getItemCount() = tomeList.size



    // Quoi afficher / The ViewHolder of the adapter

    class TomeHolder(mangaView: View) : RecyclerView.ViewHolder(mangaView) {


        fun bind(tome: Tome, listener: (Tome) -> Unit) = with(itemView)
        {

            println(tome)


          tome_list_id.text = tome.id.toString()

            tome_list_name.text = tome.name


            setOnClickListener { listener(tome) }

        }


    }
}

