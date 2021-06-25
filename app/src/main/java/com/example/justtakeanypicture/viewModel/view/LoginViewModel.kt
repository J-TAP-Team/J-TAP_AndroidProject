package com.example.justtakeanypicture.viewModel.view

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.justtakeanypicture.base.BaseViewModel
import com.example.justtakeanypicture.model.domain.LoginRequest
import com.example.justtakeanypicture.model.repository.AuthApiRepository
import com.example.justtakeanypicture.widget.SingleLiveEvent
import com.example.justtakeanypicture.widget.`object`.SharedPreferencesManager
import retrofit2.Response

class LoginViewModel(private val authApiRepository: AuthApiRepository, private val sharedPreferencesManager: SharedPreferencesManager ) : BaseViewModel() {
    val onSuccessEvent = SingleLiveEvent<Unit>()
    val onFailEvent = SingleLiveEvent<Unit>()
    val onErrorEvent = SingleLiveEvent<Unit>()
    val onSignUpEvent = SingleLiveEvent<Unit>()
    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()



    fun checkLogin() {
        Log.d("TEST" ,"T")
        if (email.value != null && password.value != null) {
            addDisposable(
                authApiRepository.login(LoginRequest(email.value!!, password.value!!))
                    .subscribe({
                        sharedPreferencesManager.setUserUid(it.Authorization)
                        onSuccessEvent.call()
                    },{
                        Log.d("Fail Login", it.toString())
                        onFailEvent.call()
                    })
            )
        }
        else {
            Log.d("TEST" , "오류 발생")
            onErrorEvent.call()
        }
    }

    fun goSignUp(){
        onSignUpEvent.call()
    }
}
