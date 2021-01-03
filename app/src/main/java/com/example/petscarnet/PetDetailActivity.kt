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
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.petscarnet.Model.Ilness
import com.example.petscarnet.Model.Pet
import com.example.petscarnet.Model.Vaccine
import org.json.JSONArray
import org.json.JSONException
import java.text.SimpleDateFormat
import java.util.*

const val EXTRA_VACCINE = "com.example.MainActivity.Vaccine"
const val EXTRA_ILLNESS = "com.example.MainActivity.Illness"

class PetDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pet_detail)

        var model = intent.getSerializableExtra(EXTRA_PET) as Pet
        val pattern = "yyyy-MM-dd"
        val simpleDateFormat = SimpleDateFormat(pattern)

        val imageView : ImageView = findViewById(R.id.iv_image)
        val titleTextView : TextView = findViewById(R.id.tv_name)
        val descTextView: TextView = findViewById(R.id.tv_description)
        val birthdayTextView: TextView = findViewById(R.id.tv_birthday)

        imageView.setImageDrawable(resources.getDrawable(model.image))
        titleTextView.text = model.name
        descTextView.text = model.description
        birthdayTextView.text = "Cumpleaños: " + simpleDateFormat.format(model.birthday)

        //Vaccines Listing

        val vaccinesListView = findViewById<ListView>(R.id.lv_lista_vacunas)
        val vaccinesList = mutableListOf<Vaccine>()

        val vaccinesArray = JSONArray(model.vaccines);
        try {

            for(i in 0 until vaccinesArray.length()){

                val vaccine = vaccinesArray.getJSONObject(i)
                val name = vaccine.getString("name")
                val applicationDate = Date(vaccine.getString("applicationDate"))
                val nextApplicationDate = Date(vaccine.getString("applicationDate"))
                val laboratory = vaccine.getString("laboratory")
                val doctor = vaccine.getString("doctor")
                val comments = vaccine.getString("comments")

                val vaccineDetail = Vaccine( name,applicationDate,nextApplicationDate,laboratory,doctor,comments)
                vaccinesList.add(vaccineDetail)
            }

        } catch (e: JSONException){
            e.printStackTrace()
        }
        vaccinesListView.adapter = VaccineDetailAdapter(this,R.layout.row_simple, vaccinesList)
        vaccinesListView.setOnItemClickListener { parent: AdapterView<*>, view: View, position:Int, id: Long ->
            var mItem : Vaccine = vaccinesList[position]
            val intent = Intent(this,VaccineDetail::class.java).apply{
                putExtra(EXTRA_VACCINE,mItem)
                putExtra(EXTRA_PET, model)
            }
            startActivity(intent)
        }

        //Illness Listing

        val illnessListView = findViewById<ListView>(R.id.lv_lista_enfermedades)
        val illnessList = mutableListOf<Ilness>()

        val illnessArray = JSONArray(model.ilnesses);
        try {

            for(i in 0 until illnessArray.length()){

                val illness = illnessArray.getJSONObject(i)
                val name = illness.getString("name")
                val treatmentStartDate = Date(illness.getString("treatmentStartDate"))
                val treatmentEndDate = Date(illness.getString("treatmentEndDate"))
                val treatment = illness.getString("treatment")
                val doctor = illness.getString("doctor")
                val comments = illness.getString("comments")

                val illnessDetail = Ilness( name,treatmentStartDate,treatmentEndDate,treatment,doctor,comments)
                illnessList.add(illnessDetail)
            }

        } catch (e: JSONException){
            e.printStackTrace()
        }
        illnessListView.adapter = IlnessDetailAdapter(this,R.layout.row_simple, illnessList)
        illnessListView.setOnItemClickListener { parent: AdapterView<*>, view: View, position:Int, id: Long ->
            var mItem : Ilness = illnessList[position]
            val intent = Intent(this,IlnessDetail::class.java).apply{
                putExtra(EXTRA_ILLNESS,mItem)
                putExtra(EXTRA_PET, model)
            }
            startActivity(intent)
        }
    }


}