package com.example.justtakeanypicture.model.domain

import java.time.LocalDateTime
import java.util.*

data class DetailedGalleryResponse(
    val gallery_id: Int,
    val user_id: Int,
    val name: String,
    val description: String,
    val created_at: String,
    val pictures: Pictures,
    val like: Int
)