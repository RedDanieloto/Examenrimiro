package Adapters

import Models.Contact
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        val image: ImageView = view.findViewById(R.id.contactImage)
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
        holder.image.setImageResource(contact.image)

        holder.itemView.setOnClickListener { onContactClick(contact) }

        // Evento para presionar el número de teléfono
        holder.phone.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:${contact.phone}"))
            it.context.startActivity(intent)
        }

        // Evento para presionar la imagen del contacto
        holder.image.setOnClickListener {
            val intent = Intent(it.context, ProfileActivity::class.java)
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = contacts.size
}
