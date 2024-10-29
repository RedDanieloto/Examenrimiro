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

        // Recuperar los datos del intent
        val name = intent.getStringExtra("CONTACT_NAME") ?: "Sin nombre"
        val phone = intent.getStringExtra("CONTACT_PHONE") ?: "Sin teléfono"
        val imageResId = intent.getIntExtra("CONTACT_IMAGE", R.drawable.perfil)

        // Vincular las vistas del layout
        val profileImageView: ImageView = findViewById(R.id.profileImage)
        val profileNameTextView: TextView = findViewById(R.id.profileName)
        val profilePhoneTextView: TextView = findViewById(R.id.profilePhone)

        // Establecer los valores en las vistas
        profileImageView.setImageResource(imageResId)
        profileNameTextView.text = name
        profilePhoneTextView.text = phone

        // Configurar el evento de clic para hacer una llamada con ACTION_DIAL
        profilePhoneTextView.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:$phone")
            }
            startActivity(intent)
        }
    }
}
