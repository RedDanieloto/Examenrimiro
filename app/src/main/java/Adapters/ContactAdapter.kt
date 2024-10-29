package Adapters

import Models.Contact
import android.content.Context
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

    // ViewHolder interno que vincula los elementos de la vista
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

        // Establecer los valores del contacto en las vistas
        holder.name.text = contact.name
        holder.phone.text = contact.phone
        holder.image.setImageResource(contact.image)

        // Configurar clic en toda la tarjeta del contacto
        holder.itemView.setOnClickListener {
            onContactClick(contact)  // Maneja el clic en la tarjeta completa
        }

        // Configurar clic en el número de teléfono para abrir el marcador (ACTION_DIAL)
        holder.phone.setOnClickListener {
            val dialIntent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:${contact.phone}")
            }
            it.context.startActivity(dialIntent)
        }

        // Configurar clic en la imagen del contacto para abrir ProfileActivity
        holder.image.setOnClickListener {
            val intent = Intent(it.context, ProfileActivity::class.java).apply {
                putExtra("CONTACT_NAME", contact.name)
                putExtra("CONTACT_PHONE", contact.phone)
                putExtra("CONTACT_IMAGE", contact.image)
            }
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = contacts.size
}
