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
import android.widget.ImageView
import android.widget.TextView
import com.example.petscarnet.Model.Ilness
import com.example.petscarnet.Model.Pet
import com.example.petscarnet.Model.Vaccine

class PetListingAdapter (var mCtx: Context,
                         val resources: Int,
                         val items:List<Pet>): ArrayAdapter<Pet>(mCtx,resources, items){

    override fun getView(position:Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater = LayoutInflater.from(mCtx)
        val view: View =layoutInflater.inflate(resources,null)
        val imageView : ImageView = view.findViewById(R.id.iv_image)
        val titleTextView : TextView = view.findViewById(R.id.tv_title)
        val descTextView: TextView = view.findViewById(R.id.tv_subtitle)
        var mItem: Pet = items[position]

        imageView.setImageDrawable(mCtx.resources.getDrawable(mItem.image))
        titleTextView.text = mItem.name
        descTextView.text = mItem.description

        return view
    }
}