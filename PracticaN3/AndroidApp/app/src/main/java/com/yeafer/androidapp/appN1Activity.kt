package com.yeafer.androidapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import com.yeafer.androidapp.botones.Botones



class appN1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_app_n1)

        //la entrada de los datos
        val numeroEditText = findViewById<EditText>(R.id.numero)

        //boton para mostrar el resultado
        val resultaditoTextView = findViewById<TextView>(R.id.resultadito)

        //boton para mandar el resultado
        val btnResult = findViewById<Button>(R.id.btnResultado)

        // es como el objeto que se usa en java
        val botones = Botones()

        //Botones de conversion
        val rbF = findViewById<RadioButton>(R.id.rbF)
        val rbR = findViewById<RadioButton>(R.id.rbR)
        val rbK = findViewById<RadioButton>(R.id.rbK)

        rbF.setOnClickListener{
           btnResult.text = "Celcius a Farenheit"
        }
        rbR.setOnClickListener{
            btnResult.text = "Celcius a Rankine"
        }
        rbK.setOnClickListener{
            btnResult.text = "Celcius a Kelvin"
        }

        btnResult.setOnClickListener {
            if (rbF.isChecked) {
                botones.FahrenheitButtonClick(numeroEditText, resultaditoTextView, applicationContext)
            }
            if (rbK.isChecked) {
                botones.KelvinButtonClick(numeroEditText, resultaditoTextView, applicationContext)
            }
            if (rbR.isChecked) {
                botones.RankineButtonClick(numeroEditText, resultaditoTextView, applicationContext)
            }


        }

        // Asignar las funciones de clic a los botones
        //findViewById<Button>(R.id.btnFarenheit).setOnClickListener {
          // botones.FahrenheitButtonClick(numeroEditText, resultaditoTextView, applicationContext)
        //}

        //findViewById<Button>(R.id.btnKelvin).setOnClickListener {
        //botones.KelvinButtonClick(numeroEditText, resultaditoTextView, applicationContext)
        // }

    //findViewById<Button>(R.id.btnRankine).setOnClickListener {
    //botones.RankineButtonClick(numeroEditText, resultaditoTextView, applicationContext)
    //}
    }
}