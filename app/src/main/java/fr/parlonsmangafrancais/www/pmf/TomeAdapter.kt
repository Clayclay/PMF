package fr.parlonsmangafrancais.www.pmf


import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


/* import kotlinx.android.synthetic.main.manga_layout.view.* */


// L ADAPTATEUR POUR TRANSMETTRE DU JSON A MANGA.KT
// adapter = objet qui contient vue unique et la duplique

class TomeAdapter(

        private val tomeList: List<Tome>,
        private val listener: (Tome) -> Unit




): RecyclerView.Adapter<TomeAdapter.TomeHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TomeHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: TomeHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    //Pour la taille
    override fun getItemCount() = tomeList.size


    // Quoi afficher / The ViewHolder of the adapter



    class TomeHolder(TomeView: View): RecyclerView.ViewHolder(TomeView) {

        fun bind(         Tome: Tome,            listener: (Tome) -> Unit) = with(itemView)
        {

            // Vue = champ / Binds a post into the view  ex : slug.text = Tome.slug

                      // tomeid.text = Tome.id.toString()

                  // tomename.text = Tome.name


            setOnClickListener { listener(Tome) }

        }
    }
}
