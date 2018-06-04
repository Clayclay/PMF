package fr.parlonsmangafrancais.www.pmf


import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import retrofit2.Call
import retrofit2.Response
import java.io.IOException


class ActivityManga : AppCompatActivity() {


    override fun onCreate(savedState: Bundle?) {
        super.onCreate(savedState)
        setContentView(R.layout.list_manga)

        val lv = findViewById(R.id.manga_list_view) as ListView





         class MangaAdapter(context: Context) : BaseAdapter() {



            // val call = GetDataService.requestid(mbid,id)


           //  val dataList: ArrayList<Manga> = ArrayList<Manga>()

             // var sList = arrayListOf<String>()



             private val mInflator: LayoutInflater

             init {
                 this.mInflator = LayoutInflater.from(context)
             }

             override fun getCount(): Int {
                // return sList.size
                 return dataList.size
             }

             override fun getItem(position: Int): Any {
               //  return sList[position]
                 return dataList[position]
             }

             override fun getItemId(position: Int): Long {
                 return position.toLong()
             }

             override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
                 val view: View?
                 val vh: ListRowHolder

                 if (convertView == null) {
                     view = this.mInflator.inflate(R.layout.row_manga, parent, false)
                     vh = ListRowHolder(view)
                     view.tag = vh
                 } else {
                     view = convertView
                     vh = view.tag as ListRowHolder
                 }


                 //vh.label.text = sList[position]

                 vh.label.text =


                 // Picasso.Builder builder = new Picasso.Builder(context);
                 //  builder.downloader(new OkHttp3Downloader(context));
                 // builder.build().load(dataList.get(position).getThumbnailUrl())
                 //   .placeholder((R.drawable.ic_launcher_background))
                 //  .error(R.drawable.ic_launcher_background)
                 //  .into(holder.coverImage);


                 return view
             }

         }


    }
    class ListRowHolder(row: View?) {
        public val label: TextView

        init {


            this.label = row?.findViewById(R.id.manganame) as TextView
        }
    }
}
















