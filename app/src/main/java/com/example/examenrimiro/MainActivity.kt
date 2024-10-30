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


        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)


        contacts.add(Contact("Alessandro", "123456789","Mi buen amigo moreno de la universidad que lamentablemente se dio de baja", R.drawable.perfil))
        contacts.add(Contact("Ramiro", "987654321","Le tutore", R.drawable.perfil))
        contacts.add(Contact("Dan", "8713352950","Yo mero", R.drawable.perfil))


        adapter = ContactAdapter(contacts) { contact ->
            val intent = Intent(this, ContactDetailActivity::class.java).apply {
                putExtra("CONTACT_NAME", contact.name)
                putExtra("CONTACT_PHONE", contact.phone)
                putExtra("CONTACT_HIST", contact.hist)
            }
            startActivity(intent)
        }
        recyclerView.adapter = adapter


        }
    }
