package com.example.justtakeanypicture.model.network

import com.example.justtakeanypicture.model.domain.LoginRequest
import com.example.justtakeanypicture.model.domain.LoginResponse
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.*


interface AuthAPI {
    // 로그인 API
    @POST("auth/login")
    fun login(
        @Body loginRequest : LoginRequest
    ) : Single<LoginResponse>
}