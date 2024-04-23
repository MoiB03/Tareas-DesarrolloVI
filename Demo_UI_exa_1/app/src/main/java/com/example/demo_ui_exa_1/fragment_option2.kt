package com.example.demo_ui_exa_1

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast

class FragmentOption2 : Fragment() {

    private lateinit var buttonver: Button
    private lateinit var radioGroup: RadioGroup

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_option2, container, false)


        radioGroup = view.findViewById(R.id.radioGroup)

        // Set the OnCheckedChangeListener to the RadioGroup
        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.radioButton1 -> Toast.makeText(requireContext(), "No es el correcto", Toast.LENGTH_SHORT).show()
                R.id.radioButton2 -> Toast.makeText(requireContext(), "No es el correcto", Toast.LENGTH_SHORT).show()
                R.id.radioButton3 -> Toast.makeText(requireContext(), "es el correcto", Toast.LENGTH_SHORT).show()
                R.id.radioButton4 -> Toast.makeText(requireContext(), "No es el correcto", Toast.LENGTH_SHORT).show()
                else -> Toast.makeText(requireContext(), "Elija una opcion", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }
}
