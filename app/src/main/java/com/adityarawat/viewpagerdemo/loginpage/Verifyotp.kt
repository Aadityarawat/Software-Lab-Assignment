package com.adityarawat.viewpagerdemo.loginpage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.UnderlineSpan
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.adityarawat.viewpagerdemo.ModelResponse.ForgotResponse
import com.adityarawat.viewpagerdemo.ModelResponse.Forgot_password
import com.adityarawat.viewpagerdemo.ModelResponse.OTPResponse
import com.adityarawat.viewpagerdemo.ModelResponse.Verify_otp
import com.adityarawat.viewpagerdemo.R
import com.adityarawat.viewpagerdemo.Service.Service
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Verifyotp : AppCompatActivity() {
    var flag : Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verifyotp)

        loginUnderline()

        val otpbtn : Button = findViewById(R.id.otpbtn)
        otpbtn.setOnClickListener {
            registration()
            if(!flag){
                val intent = Intent(this, Resetpass::class.java)
                startActivity(intent)
            }
        }

    }

    private fun loginUnderline() {
        val textView = findViewById<TextView>(R.id.otplogin)

        val text = "Resend Code"
        val spannableString = SpannableString(text)
        spannableString.setSpan(UnderlineSpan(), 0, text.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        textView.text = spannableString
    }

    private fun registration(){
        val otp1 : EditText = findViewById(R.id.otp1)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://sowlab.pw/assignment/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(Service::class.java)

        val registerationn = Verify_otp(
            otp =  otp1.text.toString()
        )

        service.postVerifyOTP(registerationn).enqueue(object : Callback<OTPResponse> {
            override fun onResponse(call: Call<OTPResponse>, response: Response<OTPResponse>) {
                if (response.isSuccessful) {
                    flag = true
                    val registerResponse = response.body()
                    Toast.makeText(this@Verifyotp,"Message: ${registerResponse?.message}",
                        Toast.LENGTH_LONG).show()
                    println("Success: ${registerResponse?.success}, Message: ${registerResponse?.message}")
                } else {
                    Toast.makeText(this@Verifyotp,"Error: ${response.errorBody()?.string()}",
                        Toast.LENGTH_LONG).show()
                    Log.i("failure","errore")
                    println("Error: ${response.errorBody()?.string()}")
                }
            }

            override fun onFailure(call: Call<OTPResponse>, t: Throwable) {
                println("Error: ${t.message}")
            }
        })
    }
}