package com.example.justtakeanypicture.model.network

import com.example.justtakeanypicture.model.domain.*
import io.reactivex.Single
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.*

interface PictureAPI {

    //사진을 업로드 하는 API
    @Multipart
    @POST("/picture")
    fun uploadPicture(
        @Header("Authorization") Authorization : String,
        @Part file: MultipartBody.Part
    ) : Single<UploadPictureResponse>

    //사진을 조회하는 API
    @GET("/picture")
    fun listPicture(
        @Header("Authorization") Authorization : String
    ) : Single<List<ListPictureResponse>>

    //내 사진을 조회하는 API
    @GET("/picture/<image_id>")
    fun detailedPicture(
        @Header("Authorization") Authorization: String,
        @Path("image_id") image_id : Int
    ) : Single<DetailedPictureResponse>

    //사진 정보를 수정하는 API
    @PATCH("/pictures/<image_id>")
    fun updatePicture(
        @Header("Authorization") Authorization: String,
        @Body updatePictureRequest: UpdatePictureRequest,
        @Path("image_id") image_id : Int
    ) : Single<UpdatePictureResponse>

    //사진 삭제
    @DELETE("pictures/<image_id>")
    fun deletePicture(
        @Header("Authorization") Authorization: String,
        @Path("image_id") image_id : Int
    ) : Single<DeletePictureResponse>
}