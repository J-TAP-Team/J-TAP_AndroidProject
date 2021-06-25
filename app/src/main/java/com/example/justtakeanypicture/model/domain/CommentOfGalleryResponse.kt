package com.example.justtakeanypicture.model.domain

import java.time.LocalDateTime
import java.util.*

data class CommentOfGalleryResponse(
    val comment_id: Int,
    val user_id: Int,
    val gallery_id: Int,
    val comment: String,
    val created_at : String
)
