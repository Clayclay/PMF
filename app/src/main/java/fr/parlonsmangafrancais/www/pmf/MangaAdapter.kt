package fr.parlonsmangafrancais.www.pmf

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.manga_layout.view.*


// L ADAPTATEUR POUR TRANSMETTRE DU JSON A MANGA.KT
// adapter = objet qui contient vue unique et la duplique

class MangaAdapter(

        private val mangaList: List<Manga>,
        private val listener: (Manga) -> Unit
): RecyclerView.Adapter<MangaAdapter.MangaHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MangaHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.manga_layout, parent, false))

    override fun onBindViewHolder(holder: MangaHolder, position: Int) = holder.bind(mangaList[position], listener)

    override fun getItemCount() = mangaList.size

    class MangaHolder(mangaView: View): RecyclerView.ViewHolder(mangaView) {

        fun bind(manga: Manga, listener: (Manga) -> Unit) = with(itemView) {

            name.text = manga.name
            status.text = manga.status

            setOnClickListener { listener(manga) }
        }
    }
}



















/*
class MangaAdapter(
        val Mangas : ArrayList<String>,
        val context: Context
) : RecyclerView.Adapter<ViewHolder>() {

    // Inflates the item views
    // attention au sens
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.row_manga, parent, false))

    }

    // Binds each manga in the ArrayList to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.MangaType.text =Mangas.get(position)
    }

    // Gets the number of animals in the list
    override fun getItemCount(): Int {
        return Mangas.size
    }





}

//class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    // Holds the TextView that will add each animal to
    // val MangaType = view.manga_name}
    */
