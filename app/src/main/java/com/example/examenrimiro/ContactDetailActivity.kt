package com.example.examenrimiro

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ContactDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_detail)

        val name = intent.getStringExtra("CONTACT_NAME")
        val hist = intent.getStringExtra("CONTACT_HIST")
        val number = intent.getStringExtra("CONTACT_NUMBER")

        findViewById<TextView>(R.id.contactDetailName).text = name
        findViewById<TextView>(R.id.contactDetailHist).text = hist


    }
}
