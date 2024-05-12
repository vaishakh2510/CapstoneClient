package com.capstone.invoicemanager
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.UnderlineSpan
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent

class SignupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        //creating underline
        val tvlogin = findViewById<TextView>(R.id.tvLoginhere)
        val underlinedText = "Login Here."
        val content = SpannableString(underlinedText)
        content.setSpan(UnderlineSpan(), 0, underlinedText.length, Spanned.SPAN_INCLUSIVE_INCLUSIVE)
        tvlogin.text = content
        tvlogin.setOnClickListener {
            // Launch the LoginActivity
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }


        }
    }
