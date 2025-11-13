package com.example.app.data.repository

import com.example.app.data.remote.MoviesResponse
import com.example.app.data.remote.RetrofitClient
import com.example.app.util.ResultState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

class MoviesRepository {

    private val api = RetrofitClient.api

    suspend fun getPopularMovies(page: Int = 1): ResultState<MoviesResponse> {
        return withContext(Dispatchers.IO) {
            try {
                val response = api.getPopularMovies(page)
                ResultState.Success(response)
            } catch (e: HttpException) {
                ResultState.Error(e.code(), e.message())
            } catch (e: IOException) {
                ResultState.Error(null, "Network Error: ${e.localizedMessage}")
            } catch (e: Exception) {
                ResultState.Error(null, "Unexpected Error: ${e.localizedMessage}")
            }
        }
    }
}
