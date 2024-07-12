package com.example.films.models

import androidx.compose.runtime.Stable
import com.example.api_ktx.CinemaService
import com.example.api_ktx.models.CinemaTodayResponse
import com.example.api_ktx.models.Film

@Stable
data class FilmUi(
    val id: String,
    val tittle: String,
    val subtitle: String,
    val img: String,
    val rating: String,
    val kinopoiskRating: String,
    val country: String,
    val year: String,
    val genres: List<String>,
    val descriptions: String
) {

    companion object {

        fun forPreview(): FilmUi {
            return FilmUi(
                id = "0",
                tittle = "Зеленая миля",
                subtitle = "The Green Mile",
                img = CinemaService.BASE_URL + "/static/images/cinema/film_8.webp",
                rating = "8.6",
                kinopoiskRating = "9.1",
                country = "США",
                year = "1999",
                genres = listOf("драма", "фэнтези", "криминал"),
                descriptions = "Пол Эджкомб — начальник блока смертников в тюрьме «Холодная гора», каждый из узников которого однажды проходит «зеленую милю» по пути к месту казни. Пол повидал много заключённых и надзирателей за время работы. Однако гигант Джон Коффи, обвинённый в страшном преступлении, стал одним из самых необычных обитателей блока."
            )
        }
    }
}


fun Film.toUi(): FilmUi {
    return FilmUi(
        id = id,
        tittle = name,
        subtitle = originalName,
        img = CinemaService.BASE_URL + img,
        rating = userRatings.imdb,
        kinopoiskRating = userRatings.kinopoisk,
        country = country.name,
        year = releaseDate.split(" ").last(),
        genres = genres,
        descriptions = description
    )
}