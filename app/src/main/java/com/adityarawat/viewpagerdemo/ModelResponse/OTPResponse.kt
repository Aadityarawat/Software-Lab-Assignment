package com.adityarawat.viewpagerdemo.ModelResponse

import java.io.Serializable

data class OTPResponse(
    val success : Boolean,
    val message : String
):Serializable
