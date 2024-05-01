package com.example.laboratorio1

import android.os.Bundle
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

            dadoAleatorio(rotarDado())

        }
        return view
    }


    private fun dadoAleatorio(numeroDado: Int) {
        if (numeroDado == 6) {
            view?.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.dorado))
            tv.text = "¡Ganaste!"
        } else {
            view?.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.gris_claro))
            tv.text = "Sigue intentando"
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

