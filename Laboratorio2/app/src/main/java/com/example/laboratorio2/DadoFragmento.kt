package com.example.laboratorio2

import android.content.Context
import com.google.firebase.firestore.FirebaseFirestore
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.*
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import kotlin.random.Random
import android.view.inputmethod.InputMethodManager
import android.widget.Toast

class DadoFragmento : Fragment() {
    private lateinit var button: Button
    private lateinit var imagen: ImageView
    private lateinit var tv: TextView
    private lateinit var tv2: TextView
    val db = FirebaseFirestore.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_dado_fragmento, container, false)

        button = view.findViewById(R.id.button)
        imagen = view.findViewById(R.id.dado)
        tv = view.findViewById(R.id.textView)
        tv2 = view.findViewById(R.id.textView2)


        val userId = arguments?.getString("ID") ?: ""
        val registerCollection = FirebaseFirestore.getInstance().collection("registro_de_puntos")
        val query = registerCollection.whereEqualTo("usuario_id", userId)

        Log.d("DadoFragmento", "ID de usuario: $userId")

        query.get().addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Log.d("si", "Entro")
                val documents = task.result
                if (documents != null && !documents.isEmpty) {
                    Log.d("si2", "Entrox2")
                    val userDocument = documents.documents[0]

                    val puntos = userDocument.getString("cantidad_de_puntos")
                    Log.d("puntos", "puntos: $puntos")
                    Log.d("DadoFragmento", "Puntos actuales del usuario: $puntos")
                    tv2.text = "Puntaje: $puntos"

                }
            }
        }


        button.setOnClickListener {

            dadoAleatorio(rotarDado(), userId)

        }
        return view
    }

    override fun onResume() {
        super.onResume()
        ocultarTeclado()
    }

    private fun ocultarTeclado() {
        val imm = requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(requireView().windowToken, 0)
    }


    private fun dadoAleatorio(numeroDado: Int, userId: String) {
        db.collection("registro_de_puntos").document(userId)
            .get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    val puntosActuales = document.getLong("cantidad_puntos") ?: 0

                    if (numeroDado == 6) {
                        view?.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.dorado))
                        tv.text = "¡Ganaste 500 puntos!"
                        sumarPuntos(userId, 500)
                    } else {
                        view?.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.gris_claro))
                        if (puntosActuales < 100) {
                            tv.text = "¡Te quedan menos de 100 puntos!"
                        } else {
                            tv.text = "Sigue intentando"
                        }
                        restarPuntos(userId, 100)
                    }
                } else {
                    Log.d("DadoFragmento", "No se encontró el documento del usuario")
                }
            }
            .addOnFailureListener { e ->
                Log.w("DadoFragmento", "Error al obtener el documento del usuario", e)
            }
    }


    private fun sumarPuntos(userId: String, puntos: Int) {
        val db = FirebaseFirestore.getInstance()
        db.collection("registro_de_puntos").document(userId)
            .get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    val puntosActuales = document.getLong("cantidad_puntos") ?: 0
                    val nuevosPuntos = puntosActuales + puntos
                    tv2.text = "Puntaje: $nuevosPuntos"
                    // Actualizar el campo cantidad_puntos en Firestore
                    db.collection("registro_de_puntos").document(userId)
                        .update("cantidad_puntos", nuevosPuntos)
                        .addOnSuccessListener {
                            Log.d("DadoFragmento", "Se sumaron $puntos puntos al usuario")
                        }
                        .addOnFailureListener { e ->
                            Log.w("DadoFragmento", "Error al sumar puntos", e)
                        }
                } else {
                    Log.d("DadoFragmento", "No se encontró el documento del usuario")
                }
            }
            .addOnFailureListener { e ->
                Log.w("DadoFragmento", "Error al obtener el documento del usuario", e)
            }
    }

    private fun restarPuntos(userId: String, puntos: Int) {
        val db = FirebaseFirestore.getInstance()
        db.collection("registro_de_puntos").document(userId)
            .get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    val puntosActuales = document.getLong("cantidad_puntos") ?: 0
                    val nuevosPuntos = puntosActuales - puntos
                    tv2.text = "Puntaje: $nuevosPuntos"
                    // Actualizar el campo cantidad_puntos en Firestore
                    db.collection("registro_de_puntos").document(userId)
                        .update("cantidad_puntos", nuevosPuntos)
                        .addOnSuccessListener {
                            Log.d("DadoFragmento", "Se restaron $puntos puntos al usuario")
                        }
                        .addOnFailureListener { e ->
                            Log.w("DadoFragmento", "Error al restar puntos", e)
                        }
                } else {
                    Log.d("DadoFragmento", "No se encontró el documento del usuario")
                }
            }
            .addOnFailureListener { e ->
                Log.w("DadoFragmento", "Error al obtener el documento del usuario", e)
            }
    }

    private fun rotarDado(): Int{
        var numeroDado =  Random.nextInt(6) + 1

        val rotateAnimation = RotateAnimation(
            0f, 360f,
            Animation.RELATIVE_TO_SELF, 0.5f,
            Animation.RELATIVE_TO_SELF, 0.5f
        )
        rotateAnimation.duration = 500 // Duración de la animación en milisegundos
        rotateAnimation.repeatCount = 0

        // Setear la imagen del dado
        when (numeroDado) {
            1 -> {
                imagen.setImageResource(R.drawable.dado1)
                imagen.startAnimation(rotateAnimation)
            }
            2 -> {
                imagen.setImageResource(R.drawable.dado2)
                imagen.startAnimation(rotateAnimation)
            }
            3 -> {
                imagen.setImageResource(R.drawable.dado3)
                imagen.startAnimation(rotateAnimation)
            }
            4 -> {
                imagen.setImageResource(R.drawable.dado4)
                imagen.startAnimation(rotateAnimation)
            }
            5 -> {
                imagen.setImageResource(R.drawable.dado5)
                imagen.startAnimation(rotateAnimation)
            }
            6 -> {
                imagen.setImageResource(R.drawable.dado6)
                imagen.startAnimation(rotateAnimation)
            }
        }
        return numeroDado
    }

}
