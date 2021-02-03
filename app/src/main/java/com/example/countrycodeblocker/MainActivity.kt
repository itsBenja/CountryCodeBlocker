package com.example.countrycodeblocker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.core.view.get
import org.json.JSONArray
import org.json.JSONStringer
import java.io.InputStream


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        jsonResult()



    }

    private fun jsonResult(){
        var json:String?=null
        val list=ArrayList<countryData>()
        val myList: ListView = findViewById(R.id.countries_list)
        val inputStream:InputStream=assets.open("countries.json")
        json = inputStream.bufferedReader().use { it.readText() }

        var jsonarr = JSONArray(json)

        for (i in 0..jsonarr.length()-1) {
            var jsonobj = jsonarr.getJSONObject(i)
            list.add(
                countryData(
                    jsonobj.getString("name"),
                    jsonobj.getString("dial_code")))
        }


        val adapter=listAdapter(this, list)
        myList.adapter=adapter

        myList.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            Toast.makeText(applicationContext, list[position].dial_code , Toast.LENGTH_LONG).show()
        }


    }



}