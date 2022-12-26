package com.example.app_imddb.data

import com.google.gson.annotations.SerializedName

data class SearcData(
    @SerializedName("Search") val data:List<MovieData>,
    @SerializedName("TotalResult") val total_data:Int
)
