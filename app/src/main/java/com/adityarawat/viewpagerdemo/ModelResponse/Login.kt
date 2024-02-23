package com.adityarawat.viewpagerdemo.ModelResponse

import android.provider.ContactsContract.CommonDataKinds.Email
import java.io.Serializable

data class Login (
    val email: String,
    val password : String,
    val role : String,
    val device_token : String,
    val type : String,
    val social_id : String
): Serializable