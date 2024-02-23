package com.adityarawat.viewpagerdemo.Service

import com.adityarawat.viewpagerdemo.ModelResponse.ForgotResponse
import com.adityarawat.viewpagerdemo.ModelResponse.Forgot_password
import com.adityarawat.viewpagerdemo.ModelResponse.Login
import com.adityarawat.viewpagerdemo.ModelResponse.LoginResponse
import com.adityarawat.viewpagerdemo.ModelResponse.OTPResponse
import com.adityarawat.viewpagerdemo.ModelResponse.Register
import com.adityarawat.viewpagerdemo.ModelResponse.RegisterResponse
import com.adityarawat.viewpagerdemo.ModelResponse.ResetPassword
import com.adityarawat.viewpagerdemo.ModelResponse.ResetResponse
import com.adityarawat.viewpagerdemo.ModelResponse.Verify_otp
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface Service {
    @POST("user/register")
    fun register(@Body request: Register): Call<RegisterResponse>

    @POST("user/login")
    fun postLogin(@Body request: Login): Call<LoginResponse>

    @POST("user/forgot-password")
    fun postForgotPass(@Body request: Forgot_password): Call<ForgotResponse>

    @POST("user/verify-otp")
    fun postVerifyOTP(@Body request: Verify_otp): Call<OTPResponse>

    @POST("user/reset-password")
    fun postResetPass(@Body request: ResetPassword): Call<ResetResponse>
}