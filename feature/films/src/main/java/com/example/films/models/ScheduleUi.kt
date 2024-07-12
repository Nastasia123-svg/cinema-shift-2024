package com.example.films.models

data class ScheduleUi(
    val dates: List<String>,
    val hall: Map<String, List<String>>
) {

    companion object {

        fun forPreview() = ScheduleUi(
            dates = List(10) {
                "12:10"
            },
            hall = emptyMap()
        )
    }
}

