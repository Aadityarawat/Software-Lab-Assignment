package com.adityarawat.viewpagerdemo.ModelResponse

import java.io.Serializable

data class ResetResponse(
    val success : Boolean,
    val message : String
): Serializable
