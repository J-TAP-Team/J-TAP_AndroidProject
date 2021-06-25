package com.example.justtakeanypicture.di.modules

import com.example.justtakeanypicture.ui.MypageFragment
import com.example.justtakeanypicture.viewModel.MainViewModel
import com.example.justtakeanypicture.viewModel.MyPageFragmentViewModel
import com.example.justtakeanypicture.viewModel.view.LoginViewModel
import com.example.justtakeanypicture.viewModel.view.SignUpViewModel
import com.example.justtakeanypicture.viewModel.view.SplashViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import kotlin.math.sin

val activityModule = module {
    //Acitivity와 관련된 ViewModel 삽입
    viewModel {
        SplashViewModel(androidApplication())
    }
    viewModel {
        MainViewModel(get(),userApiRepository = get(), galleryApiRepository = get(), pictureApiRepository = get())
    }
    viewModel {
        LoginViewModel(authApiRepository = get(), sharedPreferencesManager = get())
    }
    viewModel {
        SignUpViewModel(userApiRepository = get())
    }
    viewModel {
        MyPageFragmentViewModel()
    }
}