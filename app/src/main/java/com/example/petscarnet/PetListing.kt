/*
* Luis Eduardo Mayida González
* Programación de dispositivos móviles
* Proyecto final
* */
package com.example.petscarnet

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.petscarnet.Model.Pet
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.nio.charset.Charset
import java.util.*


const val EXTRA_PET = "com.example.MainActivity.Pet"

class PetListingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pet_listing)

        val listView = findViewById<ListView>(R.id.lv_lista)
        val list = mutableListOf<Pet>()

        try {
            val obj = JSONObject(getJsonAssets()!!)
            val petsArray = obj.getJSONArray("pets")

            for(i in 0 until petsArray.length()){

                val pet = petsArray.getJSONObject(i)
                val image = pet.getString("image")
                val resourceId = resources.getIdentifier(image, "drawable", this.getPackageName());
                val name = pet.getString("name")
                val description = pet.getString("description")
                val birthday = Date(pet.getString("birthday"))
                val vaccines = pet.getJSONArray("vaccines")
                val ilnesses = pet.getJSONArray("ilnesses")
                val petsDetail = Pet( name,description,resourceId,birthday,vaccines.toString(),ilnesses.toString())
                list.add(petsDetail)
            }
        } catch (e: JSONException){
            e.printStackTrace()
        }

        listView.adapter = PetListingAdapter(this,R.layout.row, list)
        listView.setOnItemClickListener { parent: AdapterView<*>, view: View, position:Int, id: Long ->
            var mItem : Pet = list[position]
            val intent = Intent(this,PetDetailActivity::class.java).apply{
                putExtra(EXTRA_PET,mItem)
            }
            startActivity(intent)
        }

    }

    private fun getJsonAssets():String?{
        var json:String?= null
        val charset: Charset = Charsets.UTF_8
        try{
            val myUserJSONFile = assets.open("pets.json")
            val size = myUserJSONFile.available()
            val buffer = ByteArray(size)

            myUserJSONFile.read(buffer)
            myUserJSONFile.close()
            json = String(buffer,charset)

        }catch (ex: IOException){
            ex.printStackTrace()
            return null
        }

        return json
    }
}