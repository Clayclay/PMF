package fr.parlonsmangafrancais.www.pmf


import android.content.Context
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException


class ActivityManga : AppCompatActivity() {


    override fun onCreate(savedState: Bundle?) {
        super.onCreate(savedState)
        setContentView(R.layout.list_manga)

     //   val lv = findViewById(R.id.manga_list_view) as ListView




      /*  lv.adapter= qqchose(this)*/



        }

     /*   private fun fetchMyData() {
            GetDataService.myself(API_KEY).enqueue(object : Callback {
                override fun onFailure(call: Call?, t: Throwable?) {
                }

                override fun onResponse(call: Call?, response: Response) {
                    if (response.isSuccessful) {
                        response.body()?.let {
                            AlertDialog.Builder(this@ActivityManga)
                                    .setTitle("My Data")
                                    .setMessage(it.toString()).show()
                        }
                    }
                }
            })
        }*/






}



















