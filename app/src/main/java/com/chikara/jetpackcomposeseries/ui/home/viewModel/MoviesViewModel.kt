package com.example.app.ui.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app.data.remote.Movie
import com.example.app.data.repository.MoviesRepository
import com.example.app.util.ResultState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MoviesViewModel(
    private val repository: MoviesRepository = MoviesRepository()
) : ViewModel() {

    private val _moviesState = MutableStateFlow<ResultState<List<Movie>>>(ResultState.Loading)
    val moviesState: StateFlow<ResultState<List<Movie>>> = _moviesState

    fun fetchPopularMovies(page: Int = 1) {
        viewModelScope.launch {
            _moviesState.value = ResultState.Loading

            when (val result = repository.getPopularMovies(page)) {
                is ResultState.Success -> {
                    _moviesState.value = ResultState.Success(result.data.results ?: emptyList())
                }

                is ResultState.Error -> {
                    _moviesState.value = ResultState.Error(result.code, result.message)
                }

                else -> Unit
            }
        }
    }
}
