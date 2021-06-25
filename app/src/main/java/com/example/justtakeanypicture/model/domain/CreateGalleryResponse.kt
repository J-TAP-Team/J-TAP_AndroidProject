package com.example.justtakeanypicture.model.domain

import java.time.LocalDateTime

data class CreateGalleryResponse(
    val gallery_id: Int,
    val user_id: Int,
    val name: String,
    val description: String,
    val created_at: String
)
