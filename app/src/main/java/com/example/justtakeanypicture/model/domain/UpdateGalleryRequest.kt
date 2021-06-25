package com.example.justtakeanypicture.model.domain

import retrofit2.http.Query

data class UpdateGalleryRequest(
    val name: String,
    val description: String
)