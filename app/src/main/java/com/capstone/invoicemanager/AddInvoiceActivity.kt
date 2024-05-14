package com.capstone.invoicemanager

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AddInvoiceActivity : AppCompatActivity() {
    private lateinit var tvSingleDate: TextView
    private var selectedDate: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_invoice)

        val linearLayout = findViewById<LinearLayout>(R.id.linearLayout)
        val tvSingleDate = findViewById<TextView>(R.id.tv_pick_date) // Assuming your TextView ID is 'tv_pick_date'
        this.tvSingleDate = tvSingleDate // Assign the reference to the lateinit property
        val clickListener = View.OnClickListener {
            showDatePickerDialog()
        }
        linearLayout.setOnClickListener(clickListener)
// Your existing logic for other UI elements (TextViews, Buttons, etc.)
        // Your existing logic for other UI elements (TextViews, Buttons, etc.)
        // Your existing logic for other UI elements (TextViews, Buttons, etc.)
        // Your existing logic for other UI elements (TextViews, Buttons, etc.)
        // Your existing logic for other UI elements (TextViews, Buttons, etc.)
        // Your existing logic for other UI elements (TextViews, Buttons, etc.)
        // Your existing logic for other UI elements (TextViews, Buttons, etc.)

    }
    private fun showDatePickerDialog() {
        val datePickerDialog = DatePickerDialog(this,
            { view, year, monthOfYear, dayOfMonth ->
                val selectedDate = "$year-${monthOfYear + 1}-$dayOfMonth"
                updateDateView(selectedDate) // Update text and (optional) store the date
            },
            Calendar.getInstance().get(Calendar.YEAR),
            Calendar.getInstance().get(Calendar.MONTH),
            Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        )
        datePickerDialog.show()
//        datePickerDialog.setCancelable(false)
    }

    fun updateDateView(selectedDate: String) {
        tvSingleDate.text = selectedDate
        this.selectedDate = selectedDate // Optional: store the date
    }
}