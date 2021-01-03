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
import com.example.petscarnet.Model.Ilness
import com.example.petscarnet.Model.Pet
import com.example.petscarnet.Model.Vaccine
import java.text.SimpleDateFormat

class IlnessDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ilness_detail)

        var model = intent.getSerializableExtra(EXTRA_ILLNESS) as Ilness
        var petModel = intent.getSerializableExtra(EXTRA_PET) as Pet
        val pattern = "yyyy-MM-dd"
        val simpleDateFormat = SimpleDateFormat(pattern)

        val petNameTextView : TextView = findViewById(R.id.tv_petName)
        val imageTextView : ImageView = findViewById(R.id.iv_image)

        val nameTextView : TextView = findViewById(R.id.tv_name)
        val startDateTextView: TextView = findViewById(R.id.tv_startDate)
        val endDateTextView: TextView = findViewById(R.id.tv_endDate)
        val treatmentTextView: TextView = findViewById(R.id.tv_treatment)
        val doctorTextView: TextView = findViewById(R.id.tv_doctor)
        val commentsTextView: TextView = findViewById(R.id.tv_comments)

        petNameTextView.text = petModel.name
        imageTextView.setImageDrawable(resources.getDrawable(petModel.image))

        nameTextView.text = "Nombre: "+model.name
        startDateTextView.text = "Fecha: "+simpleDateFormat.format(model.treatmentStartDate)
        endDateTextView.text = "Final de tratamiento : "+simpleDateFormat.format(model.treatmentEndDate)
        treatmentTextView.text = "Tratamiento: "+model.treatment
        doctorTextView.text = "Doctor: "+model.doctor
        commentsTextView.text = "Comentarios: "+model.comments
    }
}