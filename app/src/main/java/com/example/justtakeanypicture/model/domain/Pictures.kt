package com.example.justtakeanypicture.model.domain

import java.time.LocalDateTime
import java.util.*

data class Pictures(
    val picture_id: Int,
    val image: String,
    val filename: String,
    val description: String,
    val created_at: LocalDateTime
)
