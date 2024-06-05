/*
* Moisés Betancourt 20-70-7371
* Fernando Barrios 8-1002-1207
* */

package com.example.laboratorio1

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Extender (Termino en Kotlin Inflar) el Toolbar
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val dadoFragmento = DadoFragmento()

        val btninicio = findViewById<Button>(R.id.btnIrAJugar)
        val imgDado = findViewById<ImageView>(R.id.dado_feliz)
        val usuario = findViewById<EditText>(R.id.usuario)
        val password = findViewById<EditText>(R.id.password)

        btninicio.setOnClickListener {
            btninicio.visibility = View.GONE
            imgDado.visibility = View.GONE
            toolbar.subtitle = "¡Prueba tu suerte!"
            usuario.visibility = View.GONE
            password.visibility = View.GONE

            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, dadoFragmento)//Agregar el Fragmento al contenedor
                .commit()
        }

    }
}
