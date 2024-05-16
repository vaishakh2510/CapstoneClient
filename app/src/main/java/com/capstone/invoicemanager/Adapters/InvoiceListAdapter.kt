package com.capstone.invoicemanager.Adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.capstone.invoicemanager.EditInvoiceActivity
import com.capstone.invoicemanager.InvoiceListActivity
import com.capstone.invoicemanager.R
import com.capstone.invoicemanager.SingleInvoiceActivity
import com.capstone.invoicemanager.datas.Invoice
import java.text.SimpleDateFormat
import java.util.*


class InvoiceAdapter(private val context: Context,private val invoices: List<Invoice>) : RecyclerView.Adapter<InvoiceAdapter.InvoiceViewHolder>() {

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
        holder.dateTextView.text = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(currentItem.invoiceDate)
        // Handle entire item click (excluding edit image view)
        holder.itemView.setOnClickListener {
            val inid = currentItem.invoiceId
            val sharedPref =context.getSharedPreferences("invoice_data", Context.MODE_PRIVATE)
            val editor = sharedPref.edit()
            val invoiceId = inid
            editor.putInt("invoice_id", invoiceId)
            editor.apply()
            //val toastMessage = "You clicked position: $position in id :$inid"
            //val toast = Toast.makeText(holder.itemView.context, toastMessage, Toast.LENGTH_SHORT)
            //toast.show()
            val intent = Intent(context, SingleInvoiceActivity::class.java)
            ContextCompat.startActivity(context, intent ,null)
        }

        // Handle edit image view click
        holder.editImageView.setOnClickListener {
            //setting sharedpref to use in edit
            val sharedPref =context.getSharedPreferences("invoice_data", Context.MODE_PRIVATE)
            val editor = sharedPref.edit()
            val invoiceId = currentItem.invoiceId
            editor.putInt("invoice_id", invoiceId)
            editor.apply()
            val intent = Intent(context, EditInvoiceActivity::class.java)
            ContextCompat.startActivity(context,intent,null)



        }
    }

    override fun getItemCount() = invoices.size
}
