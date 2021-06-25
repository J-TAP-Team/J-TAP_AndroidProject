package com.example.justtakeanypicture.viewModel.view

import android.annotation.SuppressLint
import android.content.Context
import com.example.justtakeanypicture.base.BaseViewModel
import com.example.justtakeanypicture.model.domain.AddUserRequest
import com.example.justtakeanypicture.widget.SingleLiveEvent
import com.example.justtakeanypicture.widget.`object`.SharedPreferencesManager
import org.koin.core.get

class SplashViewModel(
    val context: Context
) : BaseViewModel() {

    val onSuccessEvent = SingleLiveEvent<Unit>()
    val onFailEvent = SingleLiveEvent<Unit>()

    init {
        if (SharedPreferencesManager(context).getUserUid() != null) onSuccessEvent.call()
        else onFailEvent.call()
    }
}