package com.example.justtakeanypicture.model.domain

data class AddUserRequest(
    val email: String,
    val password: String,
    val name: String
)