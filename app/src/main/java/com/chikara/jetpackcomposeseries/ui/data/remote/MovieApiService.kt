package com.chikara.jetpackcomposeseries.data.remote.api

import com.example.app.data.remote.MoviesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {
    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String = "d1b913d196c5bf34e8901b1a3cc4b959"
    ): Response<MoviesResponse>
}
