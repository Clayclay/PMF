package fr.parlonsmangafrancais.www.pmf

import android.content.Context
import android.support.v7.widget.RecyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import kotlinx.android.synthetic.main.row_manga.view.*

class MangaAdapter(val Mangas : ArrayList<String>, val context: Context) : RecyclerView.Adapter<ViewHolder>() {

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

class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    // Holds the TextView that will add each animal to
    val MangaType = view.manga_name
}