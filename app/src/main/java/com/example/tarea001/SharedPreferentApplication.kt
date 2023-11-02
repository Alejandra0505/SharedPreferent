package com.example.tarea01

import android.content.Context

class prefs(var context: Context ) {
    var nombre = "Nombre"
    var apellido = "Apellido"
    var cel = "Celular"
    var correo_e = "E-mail"

    fun nombre(name: String){
        context.getSharedPreferences(nombre, Context.MODE_PRIVATE)
            .edit()
            .putString(nombre, "Nombre")
            .apply()
    }
    fun apellido(ape: String){
        context.getSharedPreferences(apellido, Context.MODE_PRIVATE)
            .edit()
            .putString(apellido, "Apellido")
            .apply()
    }
    fun cel(celu: String){
        context.getSharedPreferences(cel, Context.MODE_PRIVATE)
            .edit()
            .putString(cel, "Celular")
            .apply()
    }
    fun correo(gmail: String){
        context.getSharedPreferences(correo_e, Context.MODE_PRIVATE)
            .edit()
            .putString(correo_e, "E-mail")
            .apply()
    }

    fun Getnombre(): String? {
        var config = context.getSharedPreferences(nombre, Context.MODE_PRIVATE)
        return config.getString(nombre, null)
    }
    fun Getapellido(): String? {
        var config = context.getSharedPreferences(apellido, Context.MODE_PRIVATE)
        return config.getString(apellido, null)
    }
    fun Getcel(): String? {
        var config = context.getSharedPreferences(cel, Context.MODE_PRIVATE)
        return config.getString(cel, null)
    }
    fun Getcorreo_e(toString: String): String? {
        var config = context.getSharedPreferences(correo_e, Context.MODE_PRIVATE)
        return config.getString(correo_e, null)
    }
}