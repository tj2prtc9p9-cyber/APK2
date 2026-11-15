package com.example.miapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val texto = findViewById<TextView>(R.id.texto)
        val boton = findViewById<Button>(R.id.boton)

        boton.setOnClickListener {
            texto.text = "¡Funciona! Ya tienes tu app"
        }
    }
}
