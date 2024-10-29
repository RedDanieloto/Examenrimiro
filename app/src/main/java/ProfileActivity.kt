package com.example.examenrimiro

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // Recuperar los datos enviados por el Intent
        val name = intent.getStringExtra("CONTACT_NAME") ?: "Sin nombre"
        val phone = intent.getStringExtra("CONTACT_PHONE") ?: "Sin teléfono"
        val imageResId = intent.getIntExtra("CONTACT_IMAGE", R.drawable.perfil)

        // Vincular las vistas con el layout
        val profileImageView: ImageView = findViewById(R.id.profileImage)
        val profileNameTextView: TextView = findViewById(R.id.contactDetailName)
        val profilePhoneTextView: TextView = findViewById(R.id.contactDetailPhone)

        // Establecer los valores en las vistas
        profileImageView.setImageResource(imageResId)
        profileNameTextView.text = name
        profilePhoneTextView.text = phone

        // Configurar clic en el número para abrir el marcador
        profilePhoneTextView.setOnClickListener {
            val dialIntent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:$phone")
            }
            startActivity(dialIntent)
        }
    }
}
