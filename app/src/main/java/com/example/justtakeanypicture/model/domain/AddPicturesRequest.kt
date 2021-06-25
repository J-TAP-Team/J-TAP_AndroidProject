package com.example.justtakeanypicture.model.domain

import retrofit2.http.Query

data class AddPicturesRequest(
    val gallery_id : Int,
    val pictures: List<Int>
)
