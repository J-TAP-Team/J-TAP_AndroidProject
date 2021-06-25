package com.example.justtakeanypicture.model.domain

data class LoginResponse(
    val status: String,
    val message: String,
    val Authorization : String
)