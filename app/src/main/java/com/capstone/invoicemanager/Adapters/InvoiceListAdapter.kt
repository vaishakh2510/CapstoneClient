package com.capstone.invoicemanager.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.capstone.invoicemanager.R
import com.capstone.invoicemanager.datas.Invoice
import java.text.SimpleDateFormat
import java.util.*


class InvoiceAdapter(private val invoices: List<Invoice>) : RecyclerView.Adapter<InvoiceAdapter.InvoiceViewHolder>() {

    inner class InvoiceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val clientNameTextView: TextView = itemView.findViewById(R.id.tv_client_name)
        val amountTextView: TextView = itemView.findViewById(R.id.tv_amount)
        val dateTextView: TextView = itemView.findViewById(R.id.tv_date)
        val editImageView: ImageView = itemView.findViewById(R.id.imageView2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InvoiceViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_invoice_item, parent, false)
        return InvoiceViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: InvoiceViewHolder, position: Int) {
        val currentItem = invoices[position]
        // Bind data to views
        holder.clientNameTextView.text = currentItem.clientName
        val textamnt = "INR.${currentItem.amount}"
        holder.amountTextView.text = textamnt// Assuming amount is an integer
        holder.dateTextView.text = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(currentItem.date)
        // Handle entire item click (excluding edit image view)
        holder.itemView.setOnClickListener {
            val inid = currentItem.invoiceId
            val toastMessage = "You clicked position: $position in id :$inid"
            val toast = Toast.makeText(holder.itemView.context, toastMessage, Toast.LENGTH_SHORT)
            toast.show()
        }

        // Handle edit image view click
        holder.editImageView.setOnClickListener {
            val toastMessage = "Clicked Edit for position: $position"
            val toast = Toast.makeText(holder.itemView.context, toastMessage, Toast.LENGTH_SHORT)
            toast.show()
            // Implement additional logic for handling edit action
        }
    }

    override fun getItemCount() = invoices.size
}
