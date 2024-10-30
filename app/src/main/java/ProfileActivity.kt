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
        val hist = intent.getStringExtra("CONTACT_HIST") ?: "Sin historia"
        val imageResId = intent.getIntExtra("CONTACT_IMAGE", R.drawable.perfil)


        val profileImageView: ImageView = findViewById(R.id.profileImage)
        val profileNameTextView: TextView = findViewById(R.id.contactDetailName)
        val profileHistTextView: TextView = findViewById(R.id.contactDetailHist)

        // Establecer los valores en las vistas
        profileImageView.setImageResource(imageResId)
        profileNameTextView.text = name
        profileHistTextView.text = hist


    }
}
