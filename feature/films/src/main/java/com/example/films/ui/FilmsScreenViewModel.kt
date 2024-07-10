package com.example.films.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.api_ktx.CinemaService
import com.example.films.models.FilmUi
import com.example.films.models.toUi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class FilmsScreenViewModel(
    private val cinemaService: CinemaService
) : ViewModel() {

    private val _state = MutableStateFlow(UIState())
    val state = _state.asStateFlow()


    init {
        viewModelScope.launch {
            runCatching {
                cinemaService.getAll()
            }.onSuccess { response ->
                if (response.success) {
                    _state.update {
                        it.copy(
                            films = response.films.map { f -> f.toUi() },
                            isLoading = false
                        )
                    }
                } else {
                    _state.update {
                        it.copy(
                            isLoading = false,
                            error = Throwable("Ошибка")
                        )
                    }
                }
            }.onFailure { t ->
                _state.update {
                    it.copy(
                        isLoading = false,
                        error = t
                    )
                }
            }

        }
    }



    data class UIState(
        val films: List<FilmUi> = emptyList(),
        val isLoading: Boolean = false,
        val error: Throwable? = null
    )


    class Factory(
        private val cinemaService: CinemaService
    ) : ViewModelProvider.Factory {

        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return FilmsScreenViewModel(cinemaService) as T
        }
    }
}