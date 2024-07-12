package com.example.api_ktx.models

data class ScheduleResponse(
    val reason: String,
    val schedules: List<Schedule>,
    val success: Boolean
)

