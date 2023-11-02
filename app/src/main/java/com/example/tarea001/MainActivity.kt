package com.example.tarea001 

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.example.tarea001.databinding.ActivityMainBinding
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        guardar()
        vali()

        binding.editTextText3.setText(getSharedPreferences("devolver", MODE_PRIVATE).getString("Nombre",""))
        binding.editTextText4.setText(getSharedPreferences("devolver", MODE_PRIVATE).getString("Apellido",""))
        binding.editTextPhone.setText(getSharedPreferences("devolver", MODE_PRIVATE).getString("Celular",""))
        binding.Edittextcorreo.setText(getSharedPreferences("devolver", MODE_PRIVATE).getString("E-mail",""))
        binding.apply {

            editTextText3.setText(com.example.tarea01.SharedPreferentApplication.Prefs.Getnombre())
            editTextText4.setText(com.example.tarea01.SharedPreferentApplication.Prefs.Getapellido())
            editTextPhone.setText(com.example.tarea01.SharedPreferentApplication.Prefs.Getcel())
            Edittextcorreo.setText(com.example.tarea01.SharedPreferentApplication.Prefs.Getcorreo_e(Edittextcorreo.text.toString()))

            btnclear.setOnClickListener {
                binding.editTextText3.text!!.clear()
                binding.editTextText4.text!!.clear()
                binding.editTextPhone.text!!.clear()
                binding.Edittextcorreo.text!!.clear()
            }

        }

    }
    fun guardar(){
        binding.apply {
            btnclear.setOnClickListener {
                if (editTextText3.text!!.isEmpty()){
                    editTextText3.error = "Este campo es obligatorio"
                }else{
                    editTextText3.error = null
                }
                if (editTextText4.text!!.isEmpty()){
                    editTextText4.error = "Este campo es obligatorio"
                }else{
                    editTextText4.error = null
                }
                if (editTextPhone.text!!.isEmpty()){
                    editTextPhone.error = "Este campo es obligatorio"
                }else{
                    editTextPhone.error = null
                }
                if (Edittextcorreo.text!!.isEmpty()){
                    Edittextcorreo.error = "Este campo es obligatorio"
                }else{
                    Edittextcorreo.error = null
                }
                if (editTextText3.error.isNullOrEmpty() && editTextText4.error.isNullOrEmpty() && editTextPhone.error.isNullOrEmpty() && Edittextcorreo.error.isNullOrEmpty()){
                    this@MainActivity.getSharedPreferences("devolver", MODE_PRIVATE)
                        .edit()
                        .putString("Nombre",editTextText3.text.toString())
                        .putString("Apellido", editTextText4.text.toString())
                        .putString("Celular", editTextPhone.text.toString())
                        .putString("E-mail", Edittextcorreo.text.toString())
                        .apply()
                    Toast.makeText(
                        this@MainActivity,
                        "REGISTRO COMPLETADO",
                        Toast.LENGTH_LONG
                    ).show()

                }
            }
        }
    }
    fun vali(){
        binding.Edittextcorreo.addTextChangedListener(){
            var validar = Pattern.matches("[A-Za-z0-9]{4,}[-_.]{1}[A-Za-z0-9]{4,}@[a-z]{3,}[.]{1}[a-z]{2,}",binding.Edittextcorreo.text.toString())
            if (validar){
                binding.Edittextcorreo.error = null
            }
            else{
                binding.Edittextcorreo.error = "no valido"
            }

        }
    }
}