package com.example.justtakeanypicture.model.domain

import retrofit2.http.Query

data class CreateLikeRequest(
    val gallery_id: Int
)