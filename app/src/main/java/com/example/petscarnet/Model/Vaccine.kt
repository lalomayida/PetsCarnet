/*
* Luis Eduardo Mayida González
* Programación de dispositivos móviles
* Proyecto final
* */
package com.example.petscarnet.Model

import java.io.Serializable
import java.util.*

class Vaccine(val name: String,
              val applicationDate: Date,
              val nextApplicationDate: Date,
              val laboratory: String,
              val doctor: String,
              val comments: String): Serializable