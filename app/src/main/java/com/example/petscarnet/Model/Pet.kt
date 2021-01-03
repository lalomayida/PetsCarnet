/*
* Luis Eduardo Mayida González
* Programación de dispositivos móviles
* Proyecto final
* */
package com.example.petscarnet.Model

import org.json.JSONArray
import java.io.Serializable
import java.util.*

class Pet(
    val name:String,
    val description:String,
    val image: Int,
    val birthday:Date,
    val vaccines: String,
    val ilnesses: String
): Serializable