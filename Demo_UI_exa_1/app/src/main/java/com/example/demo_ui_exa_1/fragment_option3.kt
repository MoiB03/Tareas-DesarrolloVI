package com.example.demo_ui_exa_1


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast


class FragmentOption3 : Fragment() {
    private lateinit var buttonShowValue: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_option3, container, false)

        buttonShowValue = view.findViewById(R.id.buttonShowValue)

        buttonShowValue.setOnClickListener {
            comidaFavoritaCristiano()

        }

        return view
    }

    private

}
