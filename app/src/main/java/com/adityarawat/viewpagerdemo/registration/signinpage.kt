package com.adityarawat.viewpagerdemo.registration

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.UnderlineSpan
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.adityarawat.viewpagerdemo.ModelResponse.Contest
import com.adityarawat.viewpagerdemo.R

class signinpage : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signinpage)

        val continuee : Button = findViewById(R.id.continuebtn)
        continuee.setOnClickListener {
            val fullname : EditText = findViewById(R.id.fullname)
            val email : EditText = findViewById(R.id.emailaddress)
            val phone : EditText = findViewById(R.id.phoneno)
            val password : EditText = findViewById(R.id.passwordsign)
            val reEnter : EditText = findViewById(R.id.reenterpass)

            Contest.fullname = fullname.text.toString()
            Contest.email = email.text.toString()
            Contest.phone = phone.text.toString()
            Contest.password = password.text.toString()
            Contest.reEnter = reEnter.text.toString()

            val intent = Intent(this, Farminfo::class.java)
            startActivity(intent)
            finish()
        }
        loginUnderline()
    }

    private fun loginUnderline() {
        val textView = findViewById<TextView>(R.id.textlogin)

        val text = "Login"
        val spannableString = SpannableString(text)
        spannableString.setSpan(UnderlineSpan(), 0, text.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        textView.text = spannableString
    }
}