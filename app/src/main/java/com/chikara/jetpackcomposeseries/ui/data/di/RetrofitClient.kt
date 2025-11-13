package com.example.app.data.remote

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private const val BASE_URL = "https://api.themoviedb.org/3/"
    private const val API_TOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJkMWI5MTNkMTk2YzViZjM0ZTg5MDFiMWEzY2M0Yjk1OSIsIm5iZiI6MTc2MTg4NzY0NS4zNTMsInN1YiI6IjY5MDQ0NTlkMGMwMTlhMGE5ZDQ2MzA3OCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.2RSIs0U6QP_ZnLZrYXscL48GGdkvpuTqmw2QYWFO7IA"

    private val authInterceptor = Interceptor { chain ->
        val newRequest: Request = chain.request().newBuilder()
            .addHeader("Authorization", "Bearer $API_TOKEN")
            .build()
        chain.proceed(newRequest)
    }

    private val client = OkHttpClient.Builder()
        .addInterceptor(authInterceptor)
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    val api: ApiService = retrofit.create(ApiService::class.java)
}
