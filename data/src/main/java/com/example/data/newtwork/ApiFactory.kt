package com.example.data.newtwork

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiFactory {

    private val retrofit: Retrofit by lazy { initRetrofit() }

    private fun initRetrofit(): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    val apiService = retrofit.create(ApiService::class.java)


    companion object {
        private const val BASE_URL = "https://run.mocky.io/"
    }
}