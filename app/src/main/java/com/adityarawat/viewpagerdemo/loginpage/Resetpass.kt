package com.adityarawat.viewpagerdemo.loginpage

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.adityarawat.viewpagerdemo.ModelResponse.ResetPassword
import com.adityarawat.viewpagerdemo.ModelResponse.ResetResponse
import com.adityarawat.viewpagerdemo.R
import com.adityarawat.viewpagerdemo.Service.Service
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Resetpass : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    var flag : Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resetpass)

        val resetbtn : Button = findViewById(R.id.resetpassbtn)

        resetbtn.setOnClickListener {
            registration()
            if(!flag){
                val intent = Intent(this, LoginPage::class.java)
                startActivity(intent)
            }
        }
    }

    private fun registration(){
        val newpass : EditText = findViewById(R.id.newpass)
        val resetpas : EditText = findViewById(R.id.confirmpass)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://sowlab.pw/assignment/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(Service::class.java)

        val registerationn = ResetPassword(
            token = "895642",
            password = newpass.text.toString(),
            cpassword = resetpas.text.toString()
        )

        service.postResetPass(registerationn).enqueue(object : Callback<ResetResponse> {
            override fun onResponse(call: Call<ResetResponse>, response: Response<ResetResponse>) {
                if (response.isSuccessful) {
                    flag = true
                    val registerResponse = response.body()
                    Toast.makeText(this@Resetpass,"Message: ${registerResponse?.message}",
                        Toast.LENGTH_LONG).show()
                    println("Success: ${registerResponse?.success}, Message: ${registerResponse?.message}")
                } else {
                    Toast.makeText(this@Resetpass,"Error: ${response.errorBody()?.string()}",
                        Toast.LENGTH_LONG).show()
                    Log.i("failure","errore")
                    println("Error: ${response.errorBody()?.string()}")
                }
            }

            override fun onFailure(call: Call<ResetResponse>, t: Throwable) {
                println("Error: ${t.message}")
            }
        })
    }

}