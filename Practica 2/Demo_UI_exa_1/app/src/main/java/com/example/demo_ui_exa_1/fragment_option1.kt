package com.example.demo_ui_exa_1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.SeekBar
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast

class FragmentOption1 : Fragment() {
    private lateinit var buttonShowValue: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_option1, container, false)

        buttonShowValue = view.findViewById(R.id.buttonShowValue)

        buttonShowValue.setOnClickListener {
            comidaFavoritaCristiano()

        }

        return view
    }

    private fun comidaFavoritaCristiano() {
        val spValue = view?.findViewById<Spinner>(R.id.spSeleccion)
        val comidaFav = spValue?.selectedItem.toString()
        when(comidaFav){
         "El bacalao" -> Toast.makeText(requireContext(), "$comidaFav no es su comida favorita", Toast.LENGTH_SHORT).show()
         "El bacalao dorado"-> Toast.makeText(requireContext(), "Correcto! El $comidaFav es su comida favorita", Toast.LENGTH_SHORT).show()
         "La Tortilla portuguesa"-> Toast.makeText(requireContext(), "$comidaFav no es su comida favorita", Toast.LENGTH_SHORT).show()
         "Las Empanadas"-> Toast.makeText(requireContext(), "$comidaFav no es su comida favorita", Toast.LENGTH_SHORT).show()
         "El Pastel de carne"-> Toast.makeText(requireContext(), "$comidaFav no es su comida favorita", Toast.LENGTH_SHORT).show()
            else
            -> Toast.makeText(requireContext(), "Elija una opcion", Toast.LENGTH_SHORT).show()
        }
    }
}
