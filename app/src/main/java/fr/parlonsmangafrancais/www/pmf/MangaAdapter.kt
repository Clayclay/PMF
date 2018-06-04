package fr.parlonsmangafrancais.www.pmf

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

private class ListExampleAdapter(context: Context) : BaseAdapter() {


    var sList = arrayListOf<String>(    )

   val dataList: ArrayList <Manga> = ArrayList<Manga>()



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
            view = this.mInflator.inflate(R.layout.row_manga, parent, false)
            vh = ListRowHolder(view)
            view.tag = vh
        } else {
            view = convertView
            vh = view.tag as ListRowHolder
        }


        vh.label.text = sList[position]

        // Picasso.Builder builder = new Picasso.Builder(context);
        //  builder.downloader(new OkHttp3Downloader(context));
        // builder.build().load(dataList.get(position).getThumbnailUrl())
        //   .placeholder((R.drawable.ic_launcher_background))
        //  .error(R.drawable.ic_launcher_background)
        //  .into(holder.coverImage);


        return view
    }
}

private class ListRowHolder(row: View?) {
    public val label: TextView

    init {




        this.label = row?.findViewById(R.id.manganame) as TextView
    }
}