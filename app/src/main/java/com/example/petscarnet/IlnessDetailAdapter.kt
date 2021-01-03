/*
* Luis Eduardo Mayida González
* Programación de dispositivos móviles
* Proyecto final
* */
package com.example.petscarnet

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.petscarnet.Model.Ilness
import com.example.petscarnet.Model.Vaccine
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class IlnessDetailAdapter (var mCtx: Context,
                           val resources: Int,
                           val items:List<Ilness>): ArrayAdapter<Ilness>(mCtx,resources, items){

    override fun getView(position:Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater = LayoutInflater.from(mCtx)
        val view: View =layoutInflater.inflate(resources,null)
        val titleTextView : TextView = view.findViewById(R.id.tv_title)
        val descTextView: TextView = view.findViewById(R.id.tv_subtitle)
        var mItem: Ilness = items[position]

        val pattern = "yyyy-MM-dd"
        val simpleDateFormat = SimpleDateFormat(pattern)

        titleTextView.text = mItem.name
        descTextView.text = simpleDateFormat.format(mItem.treatmentStartDate)

        return view
    }
}