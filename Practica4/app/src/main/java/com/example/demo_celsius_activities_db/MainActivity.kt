package com.example.demo_celsius_activities_db

/* Moises Betancourt 20-70-7371
   Fernando Barrios 8-1002-1207
   Nadim García 4-
*/

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var convertButton: Button
    private lateinit var temperatureOptions: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        convertButton = findViewById(R.id.convertButton)
        temperatureOptions = findViewById(R.id.temperatureOptions)

        convertButton.setOnClickListener(this)
    }

        private fun celsiusToFahrenheit(celsius: Double): Double {
            return (celsius * 9 / 5) + 32
        }

        private fun celsiusToKelvin(celsius: Double): Double {
            return celsius + 273.15
        }

        private fun celsiusToRankine(celsius: Double): Double {
            return (celsius * 9 / 5) + 491.67
        }

        override fun onClick(v: View?) {
            when (v?.id) {
                R.id.convertButton -> {
                    val selectedRadioButtonId = temperatureOptions.checkedRadioButtonId
                    val selectedRadioButton = findViewById<RadioButton>(selectedRadioButtonId)
                    val celsiusInput = findViewById<EditText>(R.id.celsiusInput).text.toString()

                    if (selectedRadioButton != null && celsiusInput.isNotEmpty()) {
                        val celsius = celsiusInput.toDouble()
                        val result = when (selectedRadioButton.id) {
                            R.id.optionFahrenheit -> celsiusToFahrenheit(celsius)
                            R.id.optionKelvin -> celsiusToKelvin(celsius)
                            R.id.optionRankine -> celsiusToRankine(celsius)
                            else -> return
                        }

                        val formattedResult = String.format("%.2f", result)
                        val intent = Intent(this, SecondActivity::class.java).apply {
                            putExtra("CONVERSION", selectedRadioButton.text)
                            putExtra("RESULTADO", formattedResult.toDouble())
                        }
                        startActivity(intent)
                    } else {
                        Toast.makeText(
                            this,
                            "No ha seleccionado ninguna opción o no ha ingresado un valor",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
    }
