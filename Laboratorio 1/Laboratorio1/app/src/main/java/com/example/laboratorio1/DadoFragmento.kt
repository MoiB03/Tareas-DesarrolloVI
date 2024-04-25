package com.example.laboratorio1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class DadoFragmento : Fragment() {
    private lateinit var button: Button

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
    }



   /* private fun ThrowDice{

    }*/
}