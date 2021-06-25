package com.example.justtakeanypicture.model.repository

import com.example.justtakeanypicture.model.domain.*
import com.example.justtakeanypicture.model.network.EtcAPI
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.koin.core.KoinComponent
import org.koin.core.inject

class EtcApiRepository(private val etcApi: EtcAPI) : KoinComponent {


    fun createLike(Authorization: String, createLikeRequest: CreateLikeRequest) : Single<CreateLikeResponse> {
        return etcApi.createLike(Authorization,createLikeRequest)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun createComments(Authorization: String,createCommentsRequest: CreateCommentsRequest) : Single<CreateCommentsResponse> {
        return etcApi.createComments(Authorization,createCommentsRequest)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun convertPicture(Authorization: String, convertPictureRequest: ConvertPictureRequest): Single<CreateConvertPictureResponse> {
        return etcApi.convertPicture(Authorization, convertPictureRequest)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}