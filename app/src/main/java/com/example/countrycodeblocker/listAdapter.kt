package com.example.countrycodeblocker

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class listAdapter(val context:Context, val list:ArrayList<countryData>): BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val view:View=LayoutInflater.from(context).inflate(R.layout.list_view_countries, parent, false)
        val name = view.findViewById<TextView>(R.id.countryName)
        val dial_code = view.findViewById<TextView>(R.id.countryCode)

        name.text=list[position].name.toString()
        dial_code.text=list[position].dial_code.toString()
        return view
    }

    override fun getItem(position: Int): Any {

        return position
    }

    override fun getItemId(position: Int): Long {

        return position.toLong()
    }

    override fun getCount(): Int {

        return list.size
    }


}