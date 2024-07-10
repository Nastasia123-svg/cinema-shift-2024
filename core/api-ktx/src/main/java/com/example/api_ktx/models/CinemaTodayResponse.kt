package com.example.api_ktx.models

data class CinemaTodayResponse(
    val films: List<Film>,
    val reason: String,
    val success: Boolean
)