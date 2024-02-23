package com.adityarawat.viewpagerdemo.loginpage

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.adityarawat.viewpagerdemo.ModelResponse.Login
import com.adityarawat.viewpagerdemo.ModelResponse.LoginResponse
import com.adityarawat.viewpagerdemo.R
import com.adityarawat.viewpagerdemo.Service.Service
import com.adityarawat.viewpagerdemo.registration.signinpage
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoginPage : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)

        val createac : TextView = findViewById(R.id.createac)


        createac.setOnClickListener{
            val intent = Intent(this, signinpage::class.java)
            startActivity(intent)
            finish()
        }

        val loginbtn : Button = findViewById(R.id.loginbutton)

        loginbtn.setOnClickListener {
            registration()
        }

        val forgotpass : TextView = findViewById(R.id.forgotpass)

        forgotpass.setOnClickListener{
            val intent = Intent(this, Forgotpass::class.java)
            startActivity(intent)
        }
    }

    private fun registration(){
        val email : EditText = findViewById(R.id.loginemail)
        val pass : EditText = findViewById(R.id.loginpass)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://sowlab.pw/assignment/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(Service::class.java)

        val registeration = Login(
            email= email.text.toString(),
            password = email.text.toString(),
            role = "farmer",
            device_token = "0imfnc8mVLWwsAawjYr4Rx-Af50DDqtlx",
            type = "email/facebook/google/apple",
            social_id ="0imfnc8mVLWwsAawjYr4Rx-Af50DDqtlx"
        )

        service.postLogin(registeration).enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful) {
                    val registerResponse = response.body()
                    Toast.makeText(this@LoginPage,"Message: ${registerResponse?.message}",
                        Toast.LENGTH_LONG).show()
                    println("Success: ${registerResponse?.success}, Message: ${registerResponse?.message}")
                } else {
                    Toast.makeText(this@LoginPage,"Error: ${response.errorBody()?.string()}",
                        Toast.LENGTH_LONG).show()
                    println("Error: ${response.errorBody()?.string()}")
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                println("Error: ${t.message}")
            }
        })
    }
}