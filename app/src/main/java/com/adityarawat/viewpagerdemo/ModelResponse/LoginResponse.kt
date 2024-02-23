package com.adityarawat.viewpagerdemo.ModelResponse

import java.io.Serializable

data class LoginResponse(
    val success : Boolean,
    val message : String
): Serializable
