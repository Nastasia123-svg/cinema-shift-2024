package com.example.api_ktx.models

data class Schedule(
    val date: String,
    val seances: List<Seance>
)