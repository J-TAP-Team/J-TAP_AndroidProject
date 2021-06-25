package com.example.justtakeanypicture.model.domain

import retrofit2.http.Query

data class ConvertPictureRequest(
    val image: String,
    val filter: String
)