package com.example.justtakeanypicture.di.modules

import com.example.justtakeanypicture.model.repository.*
import com.example.justtakeanypicture.widget.`object`.SharedPreferencesManager
import org.koin.dsl.module

//repository 삽입
val appModule = module {
    factory {
        AuthApiRepository(get())
    }
    factory {
        UserApiRepository(get())
    }
    factory {
        EtcApiRepository(get())
    }
    factory {
        galleryApiRepository(get())
    }
    factory {
        PictureApiRepository(get())
    }
    factory {
        SharedPreferencesManager(get())
    }
}