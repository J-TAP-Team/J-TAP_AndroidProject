package com.example.justtakeanypicture.model.repository

import com.example.justtakeanypicture.model.domain.AddUserRequest
import com.example.justtakeanypicture.model.domain.MyPageResponse
import com.example.justtakeanypicture.model.domain.RegisterResponse
import com.example.justtakeanypicture.model.network.UserAPI
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.koin.core.KoinComponent

class UserApiRepository(private val userAPI: UserAPI) : KoinComponent {


    fun getUser(Authorization : String) : Single<MyPageResponse> {
        return userAPI.getUser(Authorization)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun addUser(addUserRequest: AddUserRequest) : Single<RegisterResponse> {
        return userAPI.addUser(addUserRequest)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}



/*
SharedPreferencesManager.getUserUid(context).toString()
 */