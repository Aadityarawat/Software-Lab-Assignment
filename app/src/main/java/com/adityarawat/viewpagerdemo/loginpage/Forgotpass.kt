package com.adityarawat.viewpagerdemo.loginpage

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.adityarawat.viewpagerdemo.ModelResponse.ForgotResponse
import com.adityarawat.viewpagerdemo.ModelResponse.Forgot_password
import com.adityarawat.viewpagerdemo.ModelResponse.LoginResponse
import com.adityarawat.viewpagerdemo.R
import com.adityarawat.viewpagerdemo.Service.Service
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.properties.Delegates

class Forgotpass : AppCompatActivity() {
    var flag : Boolean = false

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgotpass)


        val btn : Button = findViewById(R.id.forgotbutton)
        btn.setOnClickListener {
            registration()
            if(flag){
                val intent = Intent(this, Verifyotp::class.java)
                startActivity(intent)
            }
        }

    }

    private fun registration(){
        val phone : EditText = findViewById(R.id.forgotphone)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://sowlab.pw/assignment/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(Service::class.java)

        val registerationn = Forgot_password(
            mobile =  phone.text.toString()
        )

        service.postForgotPass(registerationn).enqueue(object : Callback<ForgotResponse> {
            override fun onResponse(call: Call<ForgotResponse>, response: Response<ForgotResponse>) {
                if (response.isSuccessful) {
                    flag = true
                    val registerResponse = response.body()
                    Toast.makeText(this@Forgotpass,"Message: ${registerResponse?.message}",
                        Toast.LENGTH_LONG).show()
                    println("Success: ${registerResponse?.success}, Message: ${registerResponse?.message}")
                } else {
                    Toast.makeText(this@Forgotpass,"Error: ${response.errorBody()?.string()}",
                        Toast.LENGTH_LONG).show()
                    Log.i("failure","errore")
                    println("Error: ${response.errorBody()?.string()}")
                }
            }

            override fun onFailure(call: Call<ForgotResponse>, t: Throwable) {
                println("Error: ${t.message}")
            }
        })
    }

}