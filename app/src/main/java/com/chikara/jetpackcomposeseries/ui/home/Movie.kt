package com.example.app.ui.movies

import LoadingIndicator
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.chikara.jetpackcomposeseries.R
import com.chikara.jetpackcomposeseries.ui.theme.AppTypography
import com.example.app.data.remote.Movie
import com.example.app.ui.common.GlideImageView
import com.example.app.util.ResultState

@Composable
fun MoviesScreen(viewModel: MoviesViewModel = viewModel()) {
    val state by viewModel.moviesState.collectAsState(initial = ResultState.Loading)

    LaunchedEffect(Unit) {
        if (viewModel.moviesState.value !is ResultState.Success) {
            viewModel.fetchPopularMovies()
        }
    }

    when (state) {
        is ResultState.Loading -> {
            LoadingIndicator()
        }

        is ResultState.Success<*> -> {
            val movies = (state as ResultState.Success<List<Movie>>).data
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = colorResource(R.color.transparent)),
                verticalArrangement = Arrangement.spacedBy(6.dp),
                contentPadding = PaddingValues(vertical = 6.dp)
            ) {
                items(movies) { movie ->
                    MovieItem(movie)
                }
            }
        }

        is ResultState.Error -> {
            val error = state as ResultState.Error
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Error ${error.code ?: ""}: ${error.message ?: "Unknown"}",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}


@Composable
fun MovieItem(movie: Movie) {
    Card(
        shape = RoundedCornerShape(12.dp),
        elevation = 4.dp, // adds subtle shadow
        backgroundColor = colorResource(R.color.white),
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp) // Fixed height
            .padding(horizontal = 0.dp, vertical = 3.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxSize()
        ) {
            // LEFT: Image (50% width)
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
            ) {
                GlideImageView(
                    imageUrl = "https://image.tmdb.org/t/p/w500${movie.poster_path}",
                    modifier = Modifier.fillMaxSize(),
                    size = 180.dp,
                    cornerRadius = 12.dp
                )
            }

            // RIGHT: Text (50% width)
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .padding(12.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = movie.title ?: "No Title",
                    style = AppTypography.headlineLarge[16]!!,
                    maxLines = 2
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = "Release: ${movie.release_date ?: "Unknown"}",
                    style = AppTypography.headlineLarge[16]!!,
                )
            }
        }
    }
}

//
//@Preview(showBackground = true)
//@Composable
//fun PreviewMovieItem() {
//    val sampleMovie = Movie(
//        id = 1,
//        title = "Inception",
//        release_date = "2010-07-16",
//        poster_path = "/qmDpIHrmpJINaRKAfWQfftjCdyi.jpg"
//    )
//
//    MovieItem(movie = sampleMovie)
//}