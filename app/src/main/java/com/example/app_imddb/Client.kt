package com.example.app_imddb

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object Client {
    private const val BASE_URL = "http://www.omdbapi.com/"
    val instances : Api by lazy {
        val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
        retrofit.create(Api::class.java)

    }
}