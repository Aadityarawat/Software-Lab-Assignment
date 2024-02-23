package com.adityarawat.viewpagerdemo.ModelResponse

import java.io.Serializable

data class ForgotResponse(
    val success : Boolean,
    val message : String
):Serializable
