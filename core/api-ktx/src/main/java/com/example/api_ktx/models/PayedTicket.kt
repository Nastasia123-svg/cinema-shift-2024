package com.example.api_ktx.models

data class PayedTicket(
    val column: Int,
    val filmId: String,
    val phone: String,
    val row: Int,
    val seance: SeanceX
)