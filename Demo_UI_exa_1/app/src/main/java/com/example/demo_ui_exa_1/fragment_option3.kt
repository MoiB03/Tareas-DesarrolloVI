package com.example.demo_ui_exa_1

import android.app.DatePickerDialog
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.DatePicker
import android.widget.Toast
import androidx.fragment.app.Fragment
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class FragmentOption3() : Fragment() {
    private lateinit var buttonShowValue: Button
    private lateinit var datePicker: DatePicker

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_option3, container, false)

        buttonShowValue = view.findViewById(R.id.buttonShowValue)
        datePicker = view.findViewById(R.id.datePicker)

        buttonShowValue.setOnClickListener {
            obtenerFechaSeleccionada()
        }

        return view
    }

    private fun obtenerFechaSeleccionada() {
        val dia = datePicker.dayOfMonth
        val mes = datePicker.month
        val anio = datePicker.year

        val calendar = Calendar.getInstance()
        calendar.set(anio, mes, dia)

        val fechaSeleccionada = calendar.time

        verificarFecha(fechaSeleccionada)
    }
    private fun verificarFecha(fecha: Date) {

        val fechaNoJugaba = Calendar.getInstance()
        fechaNoJugaba.set(2002, Calendar.AUGUST, 14)

        val fechaActual = Calendar.getInstance()

        if (fecha.before(fechaNoJugaba.time)) {
            Toast.makeText(context, "En esa fecha todavía no jugaba", Toast.LENGTH_SHORT).show()
        } else if (fecha.after(fechaNoJugaba.time) && fecha.before(fechaActual.time)) {
            Toast.makeText(context, "En esa fecha Cristiano sigue jugando", Toast.LENGTH_SHORT).show()
        } else if (fecha.after(fechaActual.time)) {
            Toast.makeText(context, "Aun no hemos llegado a esa fecha", Toast.LENGTH_SHORT).show()
        }
    }
}