package com.example.laboratorio1

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

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

        btninicio.setOnClickListener {
            btninicio.visibility = View.GONE
            imgDado.visibility = View.GONE

            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, dadoFragmento)//Agregar el Fragmento al contenedor
                .commit()
        }




    }
}
