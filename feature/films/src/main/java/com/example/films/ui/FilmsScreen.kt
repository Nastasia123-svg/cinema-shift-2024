package com.example.films.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.BrushPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.films.R
import com.example.films.models.FilmUi
import com.example.shared.ui.theme.AppColors


@Composable
fun FilmsScreen(
    modifier: Modifier = Modifier,
    filmsScreenViewModel: FilmsScreenViewModel
) {

}

@Composable
private fun FilmsScreenImpl(
    modifier: Modifier = Modifier,
    list: List<FilmUi>,
    selected: (FilmUi) -> Unit
) {

    LazyColumn {
        items(list) {

        }
    }

}

@Preview
@Composable
fun FilmsListItem(
    modifier: Modifier = Modifier,
    filmUi: FilmUi = FilmUi.forPreview(),
    clicked: () -> Unit = {}
) {

    Column {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
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
                 contentScale = ContentScale.FillWidth
            )
            Column(
                modifier = Modifier.align(Alignment.BottomEnd)
                    .clip(RoundedCornerShape(topStart = 8.dp))
                    .background(AppColors.LightGray)
                    .padding(8.dp)

            ) {
                Text(
                    text = filmUi.genres.first()

                )
                Text(
                    text = filmUi.country + ", " + filmUi.year
                )
            }
        }

        Text(text = filmUi.tittle)
        Text(text = filmUi.subtitle)
    }

}

@Preview
@Composable
private fun FilmsScreenPreview(modifier: Modifier = Modifier) {

}