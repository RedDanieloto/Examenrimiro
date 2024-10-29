package com.example.examenrimiro

import Adapters.ContactAdapter
import Models.Contact
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ContactAdapter
    private val contacts = mutableListOf<Contact>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializar RecyclerView
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Crear contactos iniciales
        contacts.add(Contact("Alessandro", "123456789", R.drawable.perfil))
        contacts.add(Contact("Ramiro", "987654321", R.drawable.perfil))

        // Configurar el adaptador del RecyclerView
        adapter = ContactAdapter(contacts) { contact ->
            val intent = Intent(this, ContactDetailActivity::class.java).apply {
                putExtra("CONTACT_NAME", contact.name)
                putExtra("CONTACT_PHONE", contact.phone)
            }
            startActivity(intent)
        }
        recyclerView.adapter = adapter

        // Configurar botón para añadir contactos
        val addButton: Button = findViewById(R.id.addContactButton)
        addButton.setOnClickListener {
            // Añadir un nuevo contacto
            val newContact = Contact("Nuevo Contacto", "555555555", R.drawable.perfil)
            contacts.add(newContact)
            adapter.notifyItemInserted(contacts.size - 1)
        }
    }
}
