package com.example.api_ktx.models

data class FilmResponse(
    val film: Film,
    val reason: String,
    val success: Boolean
)
