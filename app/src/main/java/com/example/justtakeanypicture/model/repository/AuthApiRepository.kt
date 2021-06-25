package com.example.justtakeanypicture.model.repository

import com.example.justtakeanypicture.model.domain.LoginRequest
import com.example.justtakeanypicture.model.domain.LoginResponse
import com.example.justtakeanypicture.model.network.AuthAPI
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.koin.core.KoinComponent
import org.koin.core.inject

class AuthApiRepository(private val authApi: AuthAPI) : KoinComponent {


    fun login(loginRequest: LoginRequest): Single<LoginResponse> {
        return authApi.login(loginRequest)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}