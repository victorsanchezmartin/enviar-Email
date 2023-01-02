package com.example.enviarformulario

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var boton = findViewById<Button>(R.id.btEnviar)
        var etDestinatario = findViewById<EditText>(R.id.etDestinatario)
        var etAsunto = findViewById<EditText>(R.id.etAsunto)
        var etMensaje = findViewById<EditText>(R.id.etMensaje)

        var destinatario = etDestinatario.text
        var asunto = etAsunto.text
        var mensaje = etMensaje.text


        boton.setOnClickListener {
            val intentEmail = Intent(Intent.ACTION_SEND)
            intentEmail.type = "plain/text"
            intentEmail.putExtra(Intent.EXTRA_SUBJECT, asunto)
            intentEmail.putExtra(Intent.EXTRA_TEXT, mensaje)
            intentEmail.putExtra(Intent.EXTRA_EMAIL, arrayOf(destinatario))
            startActivity(Intent.createChooser(intentEmail, "Elige cliente de correo"))
        }
    }
}