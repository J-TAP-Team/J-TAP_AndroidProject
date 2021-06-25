package com.example.justtakeanypicture.model.repository

import com.example.justtakeanypicture.model.domain.*
import com.example.justtakeanypicture.model.network.PictureAPI
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.MultipartBody
import org.koin.core.KoinComponent
import org.koin.core.inject
import retrofit2.http.Multipart

class PictureApiRepository(private val pictureAPI: PictureAPI) : KoinComponent {

    fun uploadPicture(Authorization: String,file : MultipartBody.Part) : Single<UploadPictureResponse>{
        return pictureAPI.uploadPicture(Authorization, file)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun listPicture(Authorization: String) : Single<List<ListPictureResponse>> {
        return pictureAPI.listPicture(Authorization)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun detailedPicture(Authorization: String, image_id: Int): Single<DetailedPictureResponse> {
        return pictureAPI.detailedPicture(Authorization,image_id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun updatePicture(Authorization: String,updatePictureRequest: UpdatePictureRequest ,image_id: Int): Single<UpdatePictureResponse> {
        return pictureAPI.updatePicture(Authorization,updatePictureRequest,image_id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun deletePicture(Authorization: String, image_id: Int): Single<DeletePictureResponse> {
        return pictureAPI.deletePicture(Authorization,image_id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}