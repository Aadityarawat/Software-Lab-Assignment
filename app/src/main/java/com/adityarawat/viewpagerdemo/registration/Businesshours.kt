package com.adityarawat.viewpagerdemo.registration

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.adityarawat.viewpagerdemo.ModelResponse.Contest
import com.adityarawat.viewpagerdemo.ModelResponse.Register
import com.adityarawat.viewpagerdemo.ModelResponse.RegisterResponse
import com.adityarawat.viewpagerdemo.R
import com.adityarawat.viewpagerdemo.Service.Service
import com.adityarawat.viewpagerdemo.loginpage.Resetpass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Businesshours : AppCompatActivity() {
    var flag : Boolean = false
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_businesshours)

        val mon : TextView = findViewById(R.id.mon)
        val tue : TextView = findViewById(R.id.tue)
        val wed : TextView = findViewById(R.id.wed)
        val thu : TextView = findViewById(R.id.thu)
        val fri : TextView = findViewById(R.id.fri)
        val sat : TextView = findViewById(R.id.sat)
        val sun : TextView = findViewById(R.id.sun)
        val time1 : TextView = findViewById(R.id.time1)
        val time2 : TextView = findViewById(R.id.time2)
        val time3 : TextView = findViewById(R.id.time3)
        val time4 : TextView = findViewById(R.id.time4)
        val time5 : TextView = findViewById(R.id.time5)
        val submit : Button = findViewById(R.id.signupcontinue)

        submit.setOnClickListener {
            registration()
            if(flag){
                val intent = Intent(this, Done::class.java)
                startActivity(intent)
            }
        }

        var flag1 = false
        var flag2 = false
        var flag3 = false
        var flag4 = false
        var flag5 = false
        var flag6 = false
        var flag7 = false
        var flag8 = false
        var flag9 = false
        var flag10 = false
        var flag11 = false
        var flag12 = false

        mon.setOnClickListener {
            if (!flag1){
                mon.background = ContextCompat.getDrawable(this,R.drawable.backgroundcolor)
                flag1 = true
            }else{
                mon.background = ContextCompat.getDrawable(this,R.drawable.borderdays)
                flag1 = false
            }
        }
        tue.setOnClickListener {
            if (!flag2){
                tue.background = ContextCompat.getDrawable(this,R.drawable.backgroundcolor)
                flag2 = true
            }else{
                tue.background = ContextCompat.getDrawable(this,R.drawable.borderdays)
                flag2 = false
            }
        }
        wed.setOnClickListener {
            if (!flag3){
                wed.background = ContextCompat.getDrawable(this,R.drawable.backgroundcolor)
                flag3 = true
            }else{
                wed.background = ContextCompat.getDrawable(this,R.drawable.borderdays)
                flag3 = false
            }
        }
        thu.setOnClickListener {
            if (!flag4){
                thu.background = ContextCompat.getDrawable(this,R.drawable.backgroundcolor)
                flag4 = true
            }else{
                thu.background = ContextCompat.getDrawable(this,R.drawable.borderdays)
                flag4 = false
            }
        }
        fri.setOnClickListener {
            if (!flag5){
                fri.background = ContextCompat.getDrawable(this,R.drawable.backgroundcolor)
                flag5 = true
            }else{
                fri.background = ContextCompat.getDrawable(this,R.drawable.borderdays)
                flag5 = false
            }
        }
        sat.setOnClickListener {
            if (!flag6){
                sat.background = ContextCompat.getDrawable(this,R.drawable.backgroundcolor)
                flag6 = true
            }else{
                sat.background = ContextCompat.getDrawable(this,R.drawable.borderdays)
                flag6 = false
            }
        }
        sun.setOnClickListener {
            if (!flag7){
                sun.background = ContextCompat.getDrawable(this,R.drawable.backgroundcolor)
                flag7 = true
            }else{
                sun.background = ContextCompat.getDrawable(this,R.drawable.borderdays)
                flag7 = false
            }
        }

        time1.setOnClickListener {
            if (!flag8){
                time1.background = ContextCompat.getDrawable(this,R.drawable.backgroundcolor)
                flag8 = true
            }else{
                time1.background = ContextCompat.getDrawable(this,R.drawable.borderdays)
                flag8 = false
            }
        }
        time2.setOnClickListener {
            if (!flag9){
                time2.background = ContextCompat.getDrawable(this,R.drawable.backgroundcolor)
                flag9 = true
            }else{
                time2.background = ContextCompat.getDrawable(this,R.drawable.borderdays)
                flag9 = false
            }
        }
        time3.setOnClickListener {
            if (!flag10){
                time3.background = ContextCompat.getDrawable(this,R.drawable.backgroundcolor)
                flag10 = true
            }else{
                time3.background = ContextCompat.getDrawable(this,R.drawable.borderdays)
                flag10 = false
            }
        }
        time4.setOnClickListener {
            if (!flag11){
                time4.background = ContextCompat.getDrawable(this,R.drawable.backgroundcolor)
                flag11 = true
            }else{
                time4.background = ContextCompat.getDrawable(this,R.drawable.borderdays)
                flag11 = false
            }
        }
        time5.setOnClickListener {
            if (!flag12){
                time5.background = ContextCompat.getDrawable(this,R.drawable.backgroundcolor)
                flag12 = true
            }else{
                time5.background = ContextCompat.getDrawable(this,R.drawable.borderdays)
                flag12 = false
            }
        }


    }

    private fun registration(){

        val retrofit = Retrofit.Builder()
            .baseUrl("https://sowlab.pw/assignment/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(Service::class.java)

        val registeration = Register(
            full_name = Contest.fullname,
            email = Contest.email,
            phone = Contest.phone,
            password = Contest.password,
            role = "farmer",
            business_name = Contest.businessname,
            informal_name = Contest.informationname,
            address = Contest.street,
            city = Contest.city,
            state = Contest.state,
            zip_code = Contest.zipcode.toInt(),
            registration_proof = "my_proof.pdf",
            business_hours = mapOf(
                "mon" to listOf("8:00am - 10:00am", "10:00am - 1:00pm")
            ),
            device_token = "0imfnc8mVLWwsAawjYr4Rx-Af50DDqtlx",
            type = "email/facebook/google/apple",
            social_id = "0imfnc8mVLWwsAawjYr4Rx-Af50DDqtlx"
        )


        service.register(registeration).enqueue(object : Callback<RegisterResponse> {
            override fun onResponse(call: Call<RegisterResponse>, response: Response<RegisterResponse>) {
                if (response.isSuccessful) {
                    flag = true
                    val registerResponse = response.body()
                    Toast.makeText(this@Businesshours,"Success: ${registerResponse?.success}, Message: ${registerResponse?.message}",Toast.LENGTH_LONG).show()
                    println("Success: ${registerResponse?.success}, Message: ${registerResponse?.message}")
                } else {
                    Toast.makeText(this@Businesshours,"Error: ${response.errorBody()?.string()}",Toast.LENGTH_LONG).show()
                    println("Error: ${response.errorBody()?.string()}")
                }
            }

            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                println("Error: ${t.message}")
            }
        })
    }

    private fun day(){
        /*val mon : TextView = findViewById(R.id.mon)
        val tue : TextView = findViewById(R.id.tue)
        val wed : TextView = findViewById(R.id.wed)
        val thu : TextView = findViewById(R.id.thu)
        val fri : TextView = findViewById(R.id.fri)
        val sat : TextView = findViewById(R.id.sat)
        val sun : TextView = findViewById(R.id.sun)
        val time1 : TextView = findViewById(R.id.time1)
        val time2 : TextView = findViewById(R.id.time2)
        val time3 : TextView = findViewById(R.id.time3)
        val time4 : TextView = findViewById(R.id.time4)
        val time5 : TextView = findViewById(R.id.time5)*/
    }
}