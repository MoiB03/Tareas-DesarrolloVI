package com.yeafer.androidapp.operaciones

class Operaciones {
    fun Fahrenheit(celsius: Float): Float {
        return (9f/5f) * celsius + 32
    }

    fun Kelvin(celsius: Float): Float {
        return celsius + 273.15f
    }

    fun Rankine(celsius: Float): Float {
        val kelvin = celsius + 273.15f
        return kelvin * (9f/5f)
    }
}
