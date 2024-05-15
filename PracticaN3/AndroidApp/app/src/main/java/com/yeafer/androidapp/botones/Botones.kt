package com.yeafer.androidapp.botones

import android.content.Context
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.yeafer.androidapp.operaciones.Operaciones

class Botones {

    fun FahrenheitButtonClick(numeroEditText: EditText, context: Context) {
        val inputText = numeroEditText.text.toString()
        val operaciones = Operaciones()
        if (inputText.isNotEmpty() && (inputText.toFloatOrNull() != null || inputText.toIntOrNull() != null)) {
            val celcius = inputText.toFloat()
            val farenheit = operaciones.Fahrenheit(celcius)

        } else {
            Toast.makeText(context, "Por favor ingrese un número", Toast.LENGTH_SHORT).show()
        }
    }

    fun KelvinButtonClick(numeroEditText: EditText, context: Context) {
        val inputText = numeroEditText.text.toString()
        val operaciones = Operaciones()
        if (inputText.isNotEmpty() && (inputText.toFloatOrNull() != null || inputText.toIntOrNull() != null)) {
            val celcius = inputText.toFloat()
            val kelvin = operaciones.Kelvin(celcius)
            //
        } else {
            Toast.makeText(context, "Por favor ingrese un número", Toast.LENGTH_SHORT).show()
        }
    }

    fun RankineButtonClick(numeroEditText: EditText, context: Context) {
        val inputText = numeroEditText.text.toString()
        val operaciones = Operaciones()
        if (inputText.isNotEmpty() && (inputText.toFloatOrNull() != null || inputText.toIntOrNull() != null)) {
            val celcius = inputText.toFloat()
            val rankine = operaciones.Rankine(celcius)
            //
        } else {
            Toast.makeText(context, "Por favor ingrese un número", Toast.LENGTH_SHORT).show()
        }
    }
}
