package com.example.films.ui

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.asComposePath
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.BrushPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.graphics.shapes.RoundedPolygon
import androidx.graphics.shapes.star
import androidx.graphics.shapes.toPath
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.films.R
import com.example.films.models.FilmUi
import com.example.shared.ui.theme.AppColors
import com.example.shared.ui.theme.PrimaryButton


@Composable
fun FilmsScreen(
    modifier: Modifier = Modifier,
    filmsScreenViewModel: FilmsScreenViewModel = viewModel(),
    selected: (FilmUi) -> Unit
) {
    val state by filmsScreenViewModel.state.collectAsStateWithLifecycle()

    FilmsScreenImpl(list = state.films) {
        selected(it)
    }

    LaunchedEffect(key1 = state) {
        Log.i("App", state.toString())
    }
}

@Composable
private fun FilmsScreenImpl(
    modifier: Modifier = Modifier,
    list: List<FilmUi>,
    selected: (FilmUi) -> Unit
) {

    LazyColumn(
        contentPadding = PaddingValues(horizontal = 8.dp),
        verticalArrangement = Arrangement.spacedBy(48.dp)
    ) {
        items(list) {
            FilmsListItem(
                filmUi = it,
                clicked = {
                    selected(it)
                }
            )
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
        
        FilmInformation(filmUi = filmUi)
        PrimaryButton(text = "Подробнее") {
            clicked()
        }
    }

}

@Composable
fun RatingComponent(
    modifier: Modifier = Modifier,
    rating: Float
) {

    Box(
        modifier = Modifier
            .width(200.dp)
            .height(48.dp)

    ) {
        Box(
            modifier = Modifier.background(shape = StarsRow(), color = AppColors.Gray)
        )
        Box(
            modifier =
            Modifier
                .background(shape = StarsRow(), color = Color.Yellow)
                .fillMaxWidth(0.1f)
        )
    }
}

class StarsRow() : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val star = RoundedPolygon.star(
            numVerticesPerRadius = 5,
            radius = 24f,
            innerRadius = 12f
        ).toPath().asComposePath()
        val path = Path()

        path.addPath(star, Offset(24f, 0f))
        path.addPath(star, Offset(24f * 3, 0f))
        path.addPath(star, Offset(24f * 5, 0f))
        path.addPath(star, Offset(24f * 7, 0f))
        path.addPath(star, Offset(24f * 9, 0f))


        return Outline.Generic(path)
    }

}

@Preview
@Composable
private fun FilmsScreenPreview(modifier: Modifier = Modifier) {

}