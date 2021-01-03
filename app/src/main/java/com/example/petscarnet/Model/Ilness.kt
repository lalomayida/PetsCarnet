/*
* Luis Eduardo Mayida González
* Programación de dispositivos móviles
* Proyecto final
* */
package com.example.petscarnet.Model

import java.io.Serializable
import java.util.*

class Ilness(
    val name: String,
    val treatmentStartDate: Date,
    val treatmentEndDate: Date,
    val treatment: String,
    val doctor: String,
    val comments: String
): Serializable