package com.example.justtakeanypicture.model.network

import com.example.justtakeanypicture.model.domain.*
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.*

interface EtcAPI {
    @POST("/gallery/like")
    fun createLike(
        @Header("Authorization") Authorization : String,
        @Body createLikeRequest: CreateLikeRequest
    ) : Single<CreateLikeResponse>

    @POST("/comment")
    fun createComments(
        @Header("Authorization") Authorization : String,
        @Body createCommentsRequest: CreateCommentsRequest
    ) : Single<CreateCommentsResponse>

    @POST("/convert")
    fun convertPicture(
        @Header("Authorization") Authorization : String,
        @Body convertPictureRequest: ConvertPictureRequest
    ) : Single<CreateConvertPictureResponse>
}