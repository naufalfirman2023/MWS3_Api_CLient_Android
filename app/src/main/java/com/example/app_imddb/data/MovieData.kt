package com.example.app_imddb.data

import com.google.gson.annotations.SerializedName

 data class MovieData (
    val Year:String?,
    val Title:String?,
    @SerializedName("Poster") val img:String?
    )
