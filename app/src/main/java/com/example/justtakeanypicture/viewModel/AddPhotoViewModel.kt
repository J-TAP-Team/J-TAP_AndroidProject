package com.example.justtakeanypicture.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.justtakeanypicture.base.BaseViewModel
import com.example.justtakeanypicture.model.domain.LoginRequest
import com.example.justtakeanypicture.model.repository.PictureApiRepository
import com.example.justtakeanypicture.widget.SingleLiveEvent

class AddPhotoViewModel(private val pictureApiRepository: PictureApiRepository) : BaseViewModel() {
    val onSuccessEvent = SingleLiveEvent<Unit>()
    val onFailEvent = SingleLiveEvent<Unit>()
    val onErrorEvent = SingleLiveEvent<Unit>()
    val onSignUpEvent = SingleLiveEvent<Unit>()


    fun firstImage() {
        addDisposable(pictureApiRepository.listPicture("")
            .subscribe(

            )
        )
    }

    fun secondImage(){

    }
}