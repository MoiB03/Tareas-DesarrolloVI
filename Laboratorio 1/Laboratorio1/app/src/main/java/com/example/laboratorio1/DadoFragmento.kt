package com.example.laboratorio1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView

class DadoFragmento : Fragment() {
    private lateinit var button: Button
    private lateinit var imagen: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_dado_fragmento, container, false)

        button = view.findViewById(R.id.button)

        button.setOnClickListener {


        }
        return view
        fun dadoAleatorio(numeroDado:String){
            imagen = imagen.findViewById(R.id.dado)

            when(numeroDado){
                "1" ->     imagen.setImageResource(R.drawable.dado1)
                "2" ->     imagen.setImageResource(R.drawable.dado2)
                "3" ->     imagen.setImageResource(R.drawable.dado3)
                "4" ->     imagen.setImageResource(R.drawable.dado4)
                "5" ->     imagen.setImageResource(R.drawable.dado5)
                "6" ->     imagen.setImageResource(R.drawable.dado6)


            }

        }
    }



   /* private fun ThrowDice{

    }*/
}