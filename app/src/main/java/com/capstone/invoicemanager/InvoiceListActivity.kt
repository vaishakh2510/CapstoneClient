package com.capstone.invoicemanager

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.capstone.invoicemanager.Adapters.InvoiceAdapter
import com.capstone.invoicemanager.connection.CrudApp
import com.capstone.invoicemanager.connection.RetrofitClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Retrofit

class InvoiceListActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var invoiceAdapter: InvoiceAdapter
    private lateinit var retrofit: Retrofit
    val mainScope: CoroutineScope = CoroutineScope(Job() + Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_invoice_list)
        retrofit = RetrofitClient.create()
        val crud = retrofit.create(CrudApp::class.java)
        recyclerView = findViewById<RecyclerView>(R.id.invoiceList_recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val userId = getSharedPreferences("user_data", MODE_PRIVATE).getInt("user_id", -1)
        Log.i("@invoice", "u Id : $userId ")
        fetchInvoices(crud, userId)

    }
    private fun fetchInvoices(crud: CrudApp, userId: Int) {
        mainScope.launch {
            val response = crud.getInvoice(userId)
            if (response.isSuccessful) {
                val invoices = response.body() ?: emptyList()
                invoiceAdapter = InvoiceAdapter(invoices)
                recyclerView.adapter = invoiceAdapter
            } else {
                Log.e("InvoiceListActivity", "Error fetching invoices: ${response.code()}")
            }


        }
    }
}
