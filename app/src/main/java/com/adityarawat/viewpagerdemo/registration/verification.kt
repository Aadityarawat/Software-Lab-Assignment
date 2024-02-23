package com.adityarawat.viewpagerdemo.registration

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.adityarawat.viewpagerdemo.R

class verification : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verification)

        val vericonti : Button = findViewById(R.id.vericontinue)

        vericonti.setOnClickListener {
            val intent = Intent(this, Businesshours::class.java)
            startActivity(intent)
            finish()
        }
    }
}