package com.example.app.util

sealed class ResultState<out T> {
    data class Success<out T>(val data: T) : ResultState<T>()
    data class Error(val code: Int?, val message: String?) : ResultState<Nothing>()
    object Loading : ResultState<Nothing>()
}
