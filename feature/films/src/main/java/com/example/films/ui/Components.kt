package com.example.films.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.BrushPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.films.models.FilmUi
import com.example.shared.ui.theme.AppColors

@Composable
fun FilmInformation(
    modifier: Modifier = Modifier,
    filmUi: FilmUi
) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .then(modifier)
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp)),
            model = filmUi.img,
            contentDescription = null,
            placeholder = BrushPainter(
                Brush.linearGradient(
                    listOf(
                        Color(color = 0xFFFFFFFF),
                        Color(color = 0xFFDDDDDD),
                    )
                )
            ),
            contentScale = ContentScale.FillWidth,
            onSuccess = {

            }
        )
        Column(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .clip(RoundedCornerShape(topStart = 8.dp))
                .background(AppColors.LightGray)
                .padding(8.dp),
            horizontalAlignment = Alignment.End

        ) {
            Text(
                modifier = Modifier.padding(vertical = 4.dp),
                fontWeight = FontWeight(500),
                text = filmUi.genres.first(),

                )
            Text(
                text = filmUi.country + ", " + filmUi.year
            )
        }
    }

    Text(
        modifier = Modifier.padding(vertical = 4.dp),
        text = filmUi.tittle,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold
    )
    Text(text = filmUi.subtitle, color = AppColors.DarkGray)
    Text(
        modifier = Modifier.padding(bottom = 16.dp),
        text = "Kinopoisk - ${filmUi.kinopoiskRating}",
        color = AppColors.DarkGray
    )
}
