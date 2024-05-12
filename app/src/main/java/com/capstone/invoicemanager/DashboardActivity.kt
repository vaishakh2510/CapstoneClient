package com.capstone.invoicemanager
import android.content.Context
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        val sharedPref = getSharedPreferences("user_data", Context.MODE_PRIVATE)

        val tv = findViewById<TextView>(R.id.textView4)
        tv.text= sharedPref.getInt("user_id",0).toString()


        }
    }
