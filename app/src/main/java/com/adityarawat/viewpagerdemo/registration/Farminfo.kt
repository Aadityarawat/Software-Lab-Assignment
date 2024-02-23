package com.adityarawat.viewpagerdemo.registration

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import com.adityarawat.viewpagerdemo.ModelResponse.Contest
import com.adityarawat.viewpagerdemo.R

class Farminfo : AppCompatActivity() {
    @SuppressLint("ResourceType", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_farminfo)


        val businessname : EditText = findViewById(R.id.businessname)
        val informationname : EditText = findViewById(R.id.informationname)
        val street : EditText = findViewById(R.id.Streetaddress)
        val city : EditText = findViewById(R.id.City)
        val zipcode : EditText = findViewById(R.id.zipcode)
        val state : Spinner = findViewById(R.id.spinner)

        val states = listOf(
            "State",
            "Andhra Pradesh",
            "Arunachal Pradesh",
            "Assam",
            "Bihar",
            "Chhattisgarh",
            "Goa",
            "Gujarat",
            "Haryana",
            "Himachal Pradesh",
            "Jharkhand",
            "Karnataka",
            "Kerala",
            "Madhya Pradesh",
            "Maharashtra",
            "Manipur",
            "Meghalaya",
            "Mizoram",
            "Nagaland",
            "Odisha",
            "Punjab",
            "Rajasthan",
            "Sikkim",
            "Tamil Nadu",
            "Telangana",
            "Tripura",
            "Uttar Pradesh",
            "Uttarakhand",
            "West Bengal"
        )

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, states)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        state.adapter = adapter

        state.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                // Handle item selection
                val selectedItem = parent?.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Do nothing
            }
        }

        val vericonti : Button = findViewById(R.id.farmconti)

        vericonti.setOnClickListener {
            Contest.businessname = businessname.text.toString()
            Contest.informationname = informationname.text.toString()
            Contest.street = street.text.toString()
            Contest.city = city.text.toString()
            Contest.zipcode = zipcode.text.toString()
            Contest.state = state.selectedItem.toString()
            val intent = Intent(this, verification::class.java)
            startActivity(intent)
            finish()
        }
    }
}