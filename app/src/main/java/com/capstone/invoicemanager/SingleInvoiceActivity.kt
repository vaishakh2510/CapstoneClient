package com.capstone.invoicemanager

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar


class SingleInvoiceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_invoice)
        //setting the toolbar
        val toolbar = findViewById<Toolbar>(R.id.custom_toolbar)
        val titleTextView: TextView = findViewById<TextView>(R.id.titlebar)
        toolbar.title = ""
        titleTextView.text = "Details"

        //delete button click
            findViewById<Button>(R.id.deleteButton).setOnClickListener {
                showDeleteConfirmationDialog()
            }

        }

    private fun showDeleteConfirmationDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Delete Invoice")
        builder.setMessage("Do you want to delete this invoice?")

        builder.setPositiveButton("Yes") { dialog, which ->
            // Handle positive button click (delete invoice logic here)
            Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show()


        }

        builder.setNegativeButton("No") { dialog, which ->
            // Handle negative button click (dialog dismissed)
        }

        builder.create().show()
    }

}

