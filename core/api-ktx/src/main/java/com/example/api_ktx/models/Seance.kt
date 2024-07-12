package com.example.api_ktx.models

data class Seance(
    val hall: Hall,
    val payedTickets: List<PayedTicket>,
    val time: String
)