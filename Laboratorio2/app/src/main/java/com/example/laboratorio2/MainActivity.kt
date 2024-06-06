/*
* Moisés Betancourt 20-70-7371
* Fernando Barrios 8-1002-1207
* Nadim García 4-824-817
* */

package com.example.laboratorio2



import android.os.Bundle
import android.util.Log
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
        val bundle = Bundle()

        val btninicio = findViewById<Button>(R.id.btnIrAJugar)
        val imgDado = findViewById<ImageView>(R.id.dado_feliz)
        val usuario = findViewById<EditText>(R.id.usuario)
        val password = findViewById<EditText>(R.id.password)

        btninicio.setOnClickListener {
            Log.d("MainActivity", "Botón de inicio clickeado")

            if (usuario.text.toString().isEmpty() || password.text.toString().isEmpty()) {
                Log.d("MainActivity", "Campos de usuario o contraseña vacíos")
                Toast.makeText(applicationContext, "Por favor, ingrese todos los campos", Toast.LENGTH_SHORT).show()

                return@setOnClickListener
            }

            val usersCollection = FirebaseFirestore.getInstance().collection("usuarios")
            val query = usersCollection.whereEqualTo("username", usuario.text.toString())

            query.get().addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val documents = task.result
                    if (documents != null && !documents.isEmpty) {
                        val userDocument = documents.documents[0]
                        val storedPassword = userDocument.getString("contraseña")

                        if (storedPassword == password.text.toString()) {
                            Log.d("MainActivity", "Inicio de sesión exitoso")
                            btninicio.visibility = View.GONE
                            imgDado.visibility = View.GONE
                            toolbar.subtitle = "¡Prueba tu suerte!"
                            usuario.visibility = View.GONE
                            password.visibility = View.GONE

                            val userID = userDocument.getString("id")// Obtener el ID del usuario

                            val bundle = Bundle()
                            bundle.putString("ID", userID)

                            val transaction = supportFragmentManager.beginTransaction()

                            val dadoFragmento = DadoFragmento()
                            dadoFragmento.arguments = bundle

                            transaction.replace(R.id.fragment_container, dadoFragmento)
                            transaction.commit()

                        } else {
                            Log.d("MainActivity", "Contraseña incorrecta")
                            Toast.makeText(this, "Contraseña incorrecta", Toast.LENGTH_SHORT).show()
                        }
                    } else {
                        Log.d("MainActivity", "Usuario no encontrado")
                        Toast.makeText(this, "Usuario no encontrado", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Log.e("MainActivity", "Error al realizar la consulta a Firestore", task.exception)
                    Toast.makeText(this, "Error: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }
}
