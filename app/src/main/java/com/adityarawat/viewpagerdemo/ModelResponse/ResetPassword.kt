package com.adityarawat.viewpagerdemo.ModelResponse

import java.io.Serializable

data class ResetPassword(
    val token : String,
    val password : String,
    val cpassword : String
): Serializable
