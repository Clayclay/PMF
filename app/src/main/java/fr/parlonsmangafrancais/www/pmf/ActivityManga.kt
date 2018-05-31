package fr.parlonsmangafrancais.www.pmf


import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.icu.lang.UCharacter.GraphemeClusterBreak.T




class ActivityManga : AppCompatActivity() {



    override fun onCreate(savedState: Bundle?) {
        super.onCreate(savedState)
        setContentView(R.layout.list_manga)

        val lv = findViewById(R.id.manga_list_view) as ListView
        lv.adapter = ListExampleAdapter(this)   }

    private class ListExampleAdapter(context: Context) : BaseAdapter() {



        fun sList   (args: Manga) {
          var mangas: ArrayList<Manga> = ArrayList()
         mangas.add(Manga(1,"trouducul"))
         mangas.add(Manga(2,"chapeaupointu"))
         }

        // internal var sList = arrayOf("CupCake", "Donut", "Eclair", "Froyo", "GingerBread", "HoneyComb", "IceCream Sandwich",
        //  "Jelly Bean", "KitKat", "Lollipop", "Marshmallow", "Nougat")


        internal var sList = arrayOf( mangas.name        )
        
        //data class Manga (val name: String = "", val id: Int = 0)

       // fun sList(args: Array<String>) {        Manga1   ,  Manga2 }


      //var Manga1 = Manga (1,"trouducul")
       // var Manga2 = Manga (2,"chapeaupointu")



        //internal var sList = arrayOf(Manga1,Manga2)


        private val mInflator: LayoutInflater

        init {
            this.mInflator = LayoutInflater.from(context)
        }

        override fun getCount(): Int {
            return sList.size
        }

        override fun getItem(position: Int): Any {
            return sList[position]

        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
            val view: View?
            val vh: ListRowHolder
            if (convertView == null) {
                view = this.mInflator.inflate(R.layout.manga, parent, false)
                vh = ListRowHolder(view)
                view.tag = vh
            } else {
                view = convertView
                vh = view.tag as ListRowHolder
            }


            vh.label.text = sList[position]


           // this.Manga1 = view?.findViewById<TextView>(R.id.manganame) as Manga

            return view
        }
    }

    private class ListRowHolder(row: View?) {
        public val label: TextView

        init {
            this.label = row?.findViewById(R.id.manganame) as TextView
        }
    }
}































