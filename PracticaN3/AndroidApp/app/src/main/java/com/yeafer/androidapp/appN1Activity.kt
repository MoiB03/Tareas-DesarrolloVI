package com.yeafer.androidapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import com.yeafer.androidapp.botones.Botones



class appN1Activity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_app_n1)

        val btnResult = findViewById<Button>(R.id.btnResultado)


        btnResult.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val celsius = findViewById<EditText>(R.id.numero)
        val botones = Botones()
        val rbF = findViewById<RadioButton>(R.id.rbF)
        val rbR = findViewById<RadioButton>(R.id.rbR)
        val rbK = findViewById<RadioButton>(R.id.rbK)
        val btnResult = findViewById<Button>(R.id.btnResultado)

        when (v?.id) {
            R.id.btnResultado -> {
                if (rbF.isChecked) {
                    btnResult.text = "Celsius a Fahrenheit"
                    val resultado = botones.FahrenheitButtonClick(celsius, applicationContext)
                    val intent = Intent(this, appN2Activity::class.java)
                    val nombreF = "Fahrenheit"
                    intent.putExtra("RESULTADO", resultado)
                    intent.putExtra("NOMBRE", nombreF)
                    startActivity(intent)
                }
                if (rbK.isChecked) {
                    btnResult.text = "Celsius a Kelvin"
                    val resultado = botones.KelvinButtonClick(celsius, applicationContext)
                    val intent = Intent(this, appN2Activity::class.java)
                    val nombreK = "Kelvin"
                    intent.putExtra("RESULTADO", resultado)
                    intent.putExtra("NOMBRE", nombreK)
                    startActivity(intent)
                }
                if (rbR.isChecked) {
                    btnResult.text = "Celsius a Rankine"
                    val resultado = botones.RankineButtonClick(celsius, applicationContext)
                    val intent = Intent(this, appN2Activity::class.java)
                    val nombreR = "Rankine"
                    intent.putExtra("RESULTADO", resultado)
                    intent.putExtra("NOMBRE", nombreR)
                    startActivity(intent)
                }
            }
        }
    }
}
