package com.example.films.ui

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.films.models.FilmUi
import com.example.shared.ui.theme.AppColors
import com.example.shared.ui.theme.PrimaryButton

@Composable
fun FilmAboutScreen(
    modifier: Modifier = Modifier,
    filmAboutViewModel: FilmAboutViewModel = viewModel(
        factory = FilmAboutViewModel.Factory
    )
) {

    val state by filmAboutViewModel.state.collectAsStateWithLifecycle()
    val context = LocalContext.current

    when (state) {
        is FilmAboutViewModel.UiState.Error -> {
            Toast.makeText(
                context,
                (state as FilmAboutViewModel.UiState.Error).t.message,
                Toast.LENGTH_SHORT
            ).show()
        }

        FilmAboutViewModel.UiState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {

                CircularProgressIndicator(color = AppColors.Gray)
            }
        }

        is FilmAboutViewModel.UiState.Success -> {
            FilmAboutScreenImpl(filmUi = (state as FilmAboutViewModel.UiState.Success).filmUi!!)
        }
    }
}

@Composable
private fun FilmAboutScreenImpl(
    modifier: Modifier = Modifier,
    filmUi: FilmUi
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Column {
            FilmInformation(filmUi = filmUi, modifier = Modifier.fillMaxHeight(0.6f))
            Text(text = filmUi.descriptions, color = AppColors.DarkGray)
        }
        PrimaryButton(
            modifier = Modifier.align(Alignment.BottomCenter),
            text = "Посмотреть расписание"
        ) {

        }
    }

}

@Preview
@Composable
private fun FilmAboutScreenPreview(modifier: Modifier = Modifier) {
    FilmAboutScreenImpl(filmUi = FilmUi.forPreview())
}