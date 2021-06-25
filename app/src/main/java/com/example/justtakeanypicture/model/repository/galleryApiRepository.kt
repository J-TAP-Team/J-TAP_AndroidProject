package com.example.justtakeanypicture.model.repository

import com.example.justtakeanypicture.model.domain.*
import com.example.justtakeanypicture.model.network.GalleryAPI
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.koin.core.KoinComponent
import org.koin.core.inject

class galleryApiRepository(private val galleryAPI: GalleryAPI) : KoinComponent {

    fun createGallery(Authorization: String, createGalleryRequest: CreateGalleryRequest) : Single<CreateGalleryResponse> {
        return galleryAPI.createGallery(Authorization, createGalleryRequest)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun addPictures(Authorization: String, addPicturesRequest: AddPicturesRequest) : Single<GalleryResponse> {
        return galleryAPI.addPictures(Authorization, addPicturesRequest)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun deletePictures(Authorization: String, deletePicturesRequest: DeletePicturesRequest) : Single<GalleryResponse> {
        return galleryAPI.deletePictures(Authorization, deletePicturesRequest)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun listGallery(Authorization: String): Single<List<ListGalleryResponse>> {
        return galleryAPI.listGallery(Authorization)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun listMyGallery(Authorization: String) : Single<List<ListGalleryResponse>> {
        return galleryAPI.listMyGallery(Authorization)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun detailedGallery(Authorization: String, gallery_id: Int) : Single<DetailedGalleryResponse> {
        return galleryAPI.detailedGallery(Authorization, gallery_id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun commentsOfGallery(Authorization: String, gallery_id: Int) : Single<CommentOfGalleryResponse> {
        return galleryAPI.commentsOfGallery(Authorization, gallery_id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun updateGallery(Authorization: String,gallery_id: Int, updateGalleryRequest: UpdateGalleryRequest): Single<UpdateGalleryResponse> {
        return galleryAPI.updateGallery(Authorization, gallery_id, updateGalleryRequest)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun deleteGallery(Authorization: String,gallery_id: Int): Single<DeleteGalleryResponse> {
        return galleryAPI.deleteGallery(Authorization, gallery_id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}