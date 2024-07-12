package com.example.films.ui

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.createSavedStateHandle
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

class FilmAboutViewModel(
    private val cinemaService: CinemaService,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state: MutableStateFlow<UiState> = MutableStateFlow(UiState.Loading)
    val state = _state.asStateFlow()

    init {
        val id: String = checkNotNull(savedStateHandle["filmId"])
        viewModelScope.launch {
            runCatching { cinemaService.getById(id) }
                .onSuccess { response ->
                    if (response.success) {
                        _state.update {
                            UiState.Success(response.film.toUi())
                        }
                    } else {
                        _state.update {
                            UiState.Success(
                                error = Throwable("Ошибка")
                            )
                        }
                    }

                }.onFailure { t ->
                    _state.update {
                        UiState.Error(t)
                    }
                }

        }

    }

    sealed interface UiState {

        data object Loading : UiState
        data class Error(val t: Throwable) : UiState
        data class Success(
            val filmUi: FilmUi? = null,
            val error: Throwable? = null
        ) : UiState

    }

    companion object {

        val Factory = viewModelFactory {
            initializer {
                FilmAboutViewModel(CinemaService(), createSavedStateHandle())
            }
        }
    }
}