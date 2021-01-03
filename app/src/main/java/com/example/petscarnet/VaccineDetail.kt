/*
* Luis Eduardo Mayida González
* Programación de dispositivos móviles
* Proyecto final
* */
package com.example.petscarnet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.petscarnet.Model.Pet
import com.example.petscarnet.Model.Vaccine
import java.text.SimpleDateFormat

class VaccineDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vaccine_detail)

        var model = intent.getSerializableExtra(EXTRA_VACCINE) as Vaccine
        var petModel = intent.getSerializableExtra(EXTRA_PET) as Pet

        val pattern = "yyyy-MM-dd"
        val simpleDateFormat = SimpleDateFormat(pattern)

        val petNameTextView : TextView = findViewById(R.id.tv_petName)
        val imageTextView : ImageView = findViewById(R.id.iv_image)

        val nameTextView : TextView = findViewById(R.id.tv_name)
        val applicationDateTextView: TextView = findViewById(R.id.tv_applicationDate)
        val nextApplicationTextView: TextView = findViewById(R.id.tv_nextApplicationDate)
        val laboratoryTextView: TextView = findViewById(R.id.tv_laboratory)
        val doctorTextView: TextView = findViewById(R.id.tv_doctor)
        val commentsTextView: TextView = findViewById(R.id.tv_comments)

        petNameTextView.text = petModel.name
        imageTextView.setImageDrawable(resources.getDrawable(petModel.image))

        nameTextView.text = "Nombre: "+model.name
        applicationDateTextView.text = "Fecha: "+simpleDateFormat.format(model.applicationDate)
        nextApplicationTextView.text = "Próxima Vacuna : "+simpleDateFormat.format(model.nextApplicationDate)
        laboratoryTextView.text = "Laboratorio: "+model.laboratory
        doctorTextView.text = "Doctor: "+model.doctor
        commentsTextView.text = "Comentarios: "+model.comments
    }


}