package com.adityarawat.viewpagerdemo.ModelResponse


import java.io.Serializable

data class Register(
    val full_name: String,
    val email: String,
    val phone: String,
    val password: String,
    val role: String,
    val business_name: String,
    val informal_name: String,
    val address: String,
    val city: String,
    val state: String,
    val zip_code: Int,
    val registration_proof: String,
    val business_hours: Map<String, List<String>>,
    val device_token: String,
    val type: String,
    val social_id: String
): Serializable