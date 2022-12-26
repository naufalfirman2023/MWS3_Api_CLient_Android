package com.example.app_imddb

import com.example.app_imddb.data.SearcData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("/")
    fun getMovies(
        @Query("s") s: String?,
        @Query("apikey") apikey: String
    ): Call<SearcData>
}
