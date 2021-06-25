package com.example.justtakeanypicture.model.network

import com.example.justtakeanypicture.model.domain.AddUserRequest
import com.example.justtakeanypicture.model.domain.MyPageResponse
import com.example.justtakeanypicture.model.domain.RegisterResponse
import io.reactivex.Single
import retrofit2.http.*

interface UserAPI {
    //회원가입 API
    @FormUrlEncoded
    @POST("/user")
    fun addUser(
        @Body addUserRequest: AddUserRequest
    ) : Single<RegisterResponse>

    //내정보 가져오기 API
    @GET("/user/my")
    fun getUser(
        @Header("Authorization") Authorization : String
    ) : Single<MyPageResponse>
}