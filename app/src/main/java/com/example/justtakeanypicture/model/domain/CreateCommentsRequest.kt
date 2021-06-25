package com.example.justtakeanypicture.model.domain

import retrofit2.http.Query

data class CreateCommentsRequest(
    val gallery_id: Int,
    val comment: String
)
