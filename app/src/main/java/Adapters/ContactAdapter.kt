package Adapters

import Models.Contact
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.examenrimiro.ProfileActivity
import com.example.examenrimiro.R

class ContactAdapter(
    private val contacts: List<Contact>,
    private val onContactClick: (Contact) -> Unit
) : RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {


    inner class ContactViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.contactName)
        val phone: TextView = view.findViewById(R.id.contactPhone)
        val button: Button = view.findViewById(R.id.button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.contact_item, parent, false)
        return ContactViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact = contacts[position]


        holder.name.text = contact.name
        holder.phone.text = contact.phone



        holder.itemView.setOnClickListener {
            onContactClick(contact)
        }


        holder.phone.setOnClickListener {
            val dialIntent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:${contact.phone}")
            }
            it.context.startActivity(dialIntent)
        }


        holder.button.setOnClickListener {
            val locationIntent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("geo:19.432608,-99.133209?q=Zócalo, Ciudad de México")
            }
            it.context.startActivity(locationIntent)
        }

    }

    override fun getItemCount(): Int = contacts.size
}
