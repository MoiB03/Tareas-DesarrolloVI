package com.yeafer.androidapp.botones

import android.content.Context
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.yeafer.androidapp.operaciones.Operaciones

class Botones {

    fun FahrenheitButtonClick(numeroEditText: EditText, context: Context) : Double {
        val farenheit : Double
        val inputText = numeroEditText.text.toString()
        val operaciones = Operaciones()
        if (inputText.isNotEmpty() && (inputText.toFloatOrNull() != null || inputText.toIntOrNull() != null)) {
            val celcius = inputText.toFloat()
            farenheit = operaciones.Fahrenheit(celcius).toDouble()
            return farenheit
        } else {
            Toast.makeText(context, "Por favor ingrese un número", Toast.LENGTH_SHORT).show()
            return 1.00
        }

    }

    fun KelvinButtonClick(numeroEditText: EditText, context: Context): Double {
        val kelvin : Double
        val inputText = numeroEditText.text.toString()
        val operaciones = Operaciones()
        if (inputText.isNotEmpty() && (inputText.toFloatOrNull() != null || inputText.toIntOrNull() != null)) {
            val celcius = inputText.toFloat()
            kelvin = operaciones.Kelvin(celcius).toDouble()
            return kelvin
            //
        } else {
            Toast.makeText(context, "Por favor ingrese un número", Toast.LENGTH_SHORT).show()
            return 1.00
        }

    }

    fun RankineButtonClick(numeroEditText: EditText, context: Context): Double {
        val rankine : Double
        val inputText = numeroEditText.text.toString()
        val operaciones = Operaciones()
        if (inputText.isNotEmpty() && (inputText.toFloatOrNull() != null || inputText.toIntOrNull() != null)) {
            val celcius = inputText.toFloat()
            rankine = operaciones.Rankine(celcius).toDouble()
            return rankine

            //
        } else {
            Toast.makeText(context, "Por favor ingrese un número", Toast.LENGTH_SHORT).show()
            return 1.00
        }
    }
}
