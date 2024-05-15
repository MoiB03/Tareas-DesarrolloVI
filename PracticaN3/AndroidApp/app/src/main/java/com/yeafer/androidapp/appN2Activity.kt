package com.yeafer.androidapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.demo_celsius_activities_db.Fragment1
import com.yeafer.androidapp.BDHelper.BDHelper

class appN2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app_n2)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, Fragment1())
            .commit()

        //Ejecutar la respuesta del MainActivity cuando se crea
        val resultado = intent.getDoubleExtra("RESULTADO", 0.0)
        val numero = intent.getStringExtra("RESULTADO")

        /** Guardar el resultado en la base de datos, comumente el archivo de se crea en:
        /data/data/com.tu.paquete/databases/tu_base_de_datos.db **/
        val dbHelper = BDHelper(this)
        dbHelper.addConversionResult(resultado, numero)

    }
}