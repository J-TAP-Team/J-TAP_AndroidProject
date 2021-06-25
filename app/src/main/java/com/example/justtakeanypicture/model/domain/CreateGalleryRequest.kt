package com.example.justtakeanypicture.model.domain

import retrofit2.http.Query

data class CreateGalleryRequest(
    val name: String,
    val description: String
)