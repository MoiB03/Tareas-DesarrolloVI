/*
* Moisés Betancourt 20-70-7371
* Fernando Barrios 8-1002-1207
* */

package com.example.laboratorio1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.firebase.firestore.FirebaseFirestore



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

            if (usuario.text.toString().isEmpty() || password.text.toString().isEmpty()) {
                Toast.makeText(this, "Por favor, ingrese todos los campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val usersCollection = FirebaseFirestore.getInstance().collection("usuarios")
            val query = usersCollection.whereEqualTo("nombre", nombreUsuario)

            query.get().addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val documents = task.result
                    if (documents != null && !documents.isEmpty) {
                        val userDocument = documents.documents[0]
                        val storedPassword = userDocument.getString("contraseña")

                        // Verificar si la contraseña almacenada coincide con la contraseña ingresada
                        if (storedPassword == password) {
                            // La contraseña es correcta, inicio de sesión exitoso
                            startActivity(Intent(this, GameActivity::class.java))
                            finish()
                        } else {
                            // La contraseña es incorrecta
                            Toast.makeText(this, "Contraseña incorrecta", Toast.LENGTH_SHORT).show()
                        }
                    } else {
                        // No se encontró ningún usuario con ese nombre de usuario
                        Toast.makeText(this, "Usuario no encontrado", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    // Error al realizar la consulta a Firestore
                    Toast.makeText(this, "Error: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }


        }

    }
}
