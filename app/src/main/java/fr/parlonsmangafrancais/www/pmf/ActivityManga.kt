package fr.parlonsmangafrancais.www.pmf


import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*



class ActivityManga : AppCompatActivity() {


    override fun onCreate(savedState: Bundle?) {
        super.onCreate(savedState)
        setContentView(R.layout.list_manga)

        val lv = findViewById(R.id.manga_list_view) as ListView
        lv.adapter = ListExampleAdapter(this)
    }

    private class ListExampleAdapter(context: Context) : BaseAdapter() {



            val manga= Manga( "Epic Games",1)
            val manga2 = Manga("hehe",2)


        val name= manga.name


           var sList = arrayListOf<String>(name)


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




                return view
            }
        }

        private class ListRowHolder(row: View?) {
            public val label: TextView

            init {
                this.label = row?.findViewById(R.id.MangaLabelName) as TextView
            }
        }
    }































