package com.adityarawat.viewpagerdemo.ModelResponse

import java.io.Serializable

data class Days (
    val mon: List<String>,
    val tue: List<String>,
    val wed: List<String>,
    val thu: List<String>,
    val fri: List<String>,
    val sat: List<String>,
    val sun: List<String>

): Serializable