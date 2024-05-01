package com.example.laboratorio1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random

class DadoFragmento : Fragment() {
    private lateinit var button: Button
    private lateinit var imagen: ImageView
    private lateinit var tv: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_dado_fragmento, container, false)

        button = view.findViewById(R.id.button)
        imagen = view.findViewById(R.id.dado)
        tv =view.findViewById(R.id.textView)
        button.setOnClickListener {
            val numeroAleatorio = generarNumeroAleatorio()
            dadoAleatorio(numeroAleatorio.toString())
        }
        return view
    }

    private fun dadoAleatorio(numeroDado: String) {
        if (numeroDado == "6") {
            view?.setBackgroundColor(resources.getColor(android.R.color.holo_green_dark))
            tv.text = "¡Ganaste!"
        } else {
            view?.setBackgroundColor(resources.getColor(android.R.color.white))
            tv.text = "Sigue intentando"
        }

        // Setear la imagen del dado
        when (numeroDado) {
            "1" -> imagen.setImageResource(R.drawable.dado1)
            "2" -> imagen.setImageResource(R.drawable.dado2)
            "3" -> imagen.setImageResource(R.drawable.dado3)
            "4" -> imagen.setImageResource(R.drawable.dado4)
            "5" -> imagen.setImageResource(R.drawable.dado5)
            "6" -> imagen.setImageResource(R.drawable.dado6)
        }
    }



    private fun generarNumeroAleatorio(): Int {
        return Random.nextInt(6) + 1
    }
}
