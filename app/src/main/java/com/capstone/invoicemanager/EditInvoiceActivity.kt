package com.capstone.invoicemanager

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class EditInvoiceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_invoice)

        //setting the toolbar
        val toolbar = findViewById<Toolbar>(R.id.custom_toolbar)
        val titleTextView: TextView = findViewById(R.id.titlebar)
        toolbar.title = ""
        titleTextView.text = "Edit Invoice"



    }
}