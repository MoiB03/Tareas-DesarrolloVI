package com.example.demo_ui_exa_1

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment

class FragmentOption4 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_option4, container, false)

        val listView = view.findViewById<ListView>(R.id.listViewCristiano)

        val items = listOf(
            "Balón de Oro",
            "Champions League",
            "Premier League"
        )

        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, items)
        listView.adapter = adapter

        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val selectedItem = items[position]
            val numberOfTitles = getNumberOfTitles(selectedItem)

            val alertDialogBuilder = AlertDialog.Builder(requireContext())
            alertDialogBuilder.setTitle("Logros de Cristiano")
            alertDialogBuilder.setMessage("Número de títulos de $selectedItem: $numberOfTitles")
            alertDialogBuilder.setPositiveButton("Aceptar") { dialog, _ ->
                dialog.dismiss()
            }
            alertDialogBuilder.show()
        }

        return view
    }

    private fun getNumberOfTitles(title: String): Int {
        return when (title) {
            "Balón de Oro" -> 5
            "Champions League" -> 4
            "Premier League" -> 3
            else -> 0
        }
    }
}
