package com.example.justtakeanypicture.model.domain

import retrofit2.http.Query

data class DeletePicturesRequest(
    val gallery_id : Int,
    val pictures: Array<Int>
)
