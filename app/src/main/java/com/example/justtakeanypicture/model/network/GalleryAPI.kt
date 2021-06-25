package com.example.justtakeanypicture.model.network

import com.example.justtakeanypicture.model.domain.*
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.*

interface GalleryAPI {
    //갤러리 생성 API
    @POST("/gallery")
    fun createGallery(
        @Header("Authorization") Authorization : String,
        @Body createGalleryRequest: CreateGalleryRequest
    ): Single<CreateGalleryResponse>

    //갤러리 사진 추가 API
    @POST("/gallery/picture")
    fun addPictures(
        @Header("Authorization") Authorization : String,
        @Body addPicturesRequest: AddPicturesRequest
    ) : Single<GalleryResponse>

    //갤러리 사진 삭제 API
    @DELETE("/gallery/picture")
    fun deletePictures(
        @Header("Authorization") Authorization : String,
        @Body deletePicturesRequest: DeletePicturesRequest
    ) : Single<GalleryResponse>

    //갤러리 조회 API
    @GET("/gallery")
    fun listGallery(
        @Header("Authorization") Authorization : String
    ) : Single<List<ListGalleryResponse>>

    //내 갤러리 조회 API
    @GET("gallery/my")
    fun listMyGallery(
        @Header("Authorization") Authorization : String
    ) : Single<List<ListGalleryResponse>>

    //갤러리 상세 조회 API
    @GET("/gallery/<gallery_id>")
    fun detailedGallery(
        @Header("Authorization") Authorization : String,
        @Path("gallery_id") gallery_id : Int
    ): Single<DetailedGalleryResponse>

    //댓글 List API
    @GET("/gallery/<gallery_id>/comments")
    fun commentsOfGallery(
        @Header("Authorization") Authorization : String,
        @Path("gallery_id") gallery_id : Int
    ): Single<CommentOfGalleryResponse>

    //갤러리 수정
    @PATCH("pictures/<image_id>")
    fun updateGallery(
        @Header("Authorization") Authorization : String,
        @Path("gallery_id") gallery_id : Int,
        @Body updateGalleryRequest: UpdateGalleryRequest
    ) : Single<UpdateGalleryResponse>

    //갤러리 삭제
    @DELETE("/gallery/<gallery_id>")
    fun deleteGallery(
        @Header("Authorization") Authorization : String,
        @Path("gallery_id") gallery_id : Int
    ) : Single<DeleteGalleryResponse>
}