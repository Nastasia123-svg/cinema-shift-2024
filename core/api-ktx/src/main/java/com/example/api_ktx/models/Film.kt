package com.example.api_ktx.models

data class Film(
    val actors: List<Actor>,
    val ageRating: String,
    val country: Country,
    val description: String,
    val directors: List<Director>,
    val genres: List<String>,
    val id: String,
    val img: String,
    val name: String,
    val originalName: String,
    val releaseDate: String,
    val runtime: Int,
    val userRatings: UserRatings
)