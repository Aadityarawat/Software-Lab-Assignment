package com.adityarawat.viewpagerdemo.registration

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.adityarawat.viewpagerdemo.R
import com.adityarawat.viewpagerdemo.loginpage.LoginPage

class Done : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_done)
        val gotit : Button = findViewById(R.id.gotit)

        gotit.setOnClickListener {
            val intent = Intent(this@Done,LoginPage::class.java)
            startActivity(intent)
            finish()
        }
    }
}