package com.example.tarea01

import android.app.Application

class SharedPreferentApplication : Application() {
    companion object {
        lateinit var Prefs: prefs
    }

    override fun onCreate() {
        super.onCreate()
        Prefs = prefs(this)

    }
}