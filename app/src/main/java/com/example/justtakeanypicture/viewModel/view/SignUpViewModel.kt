package com.example.justtakeanypicture.viewModel.view

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.justtakeanypicture.base.BaseViewModel
import com.example.justtakeanypicture.model.domain.AddUserRequest
import com.example.justtakeanypicture.model.domain.RegisterResponse
import com.example.justtakeanypicture.model.network.UserAPI
import com.example.justtakeanypicture.model.repository.UserApiRepository
import com.example.justtakeanypicture.widget.SingleLiveEvent
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpViewModel(private val userApiRepository: UserApiRepository) : BaseViewModel() {
    val onSuccessEvent = SingleLiveEvent<Unit>()
    val onFailEvent = SingleLiveEvent<Unit>()
    val onErrorEvent = SingleLiveEvent<Unit>()
    val onLoginEvent = SingleLiveEvent<Unit>()

    val name = MutableLiveData<String>()

    val email = MutableLiveData<String>()

    val password = MutableLiveData<String>()

    fun signUp() {
        Log.d("email", email.toString())
        if (email.value != null && password.value != null && name.value != null) {
            Log.d("email",email.value.toString())
        addDisposable(
            userApiRepository.addUser(AddUserRequest(email = email.value!!, password = password.value!!, name = name.value!!))
                .subscribe({
                    onSuccessEvent.call()
                }, { onFailEvent.call() })
            )
        }
        else {
            onErrorEvent.call()
        }
    }

    fun goLoginUp() {
        onLoginEvent.call()
    }
}