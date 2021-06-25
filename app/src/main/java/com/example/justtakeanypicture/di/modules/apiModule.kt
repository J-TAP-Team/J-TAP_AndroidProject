package com.example.justtakeanypicture.di.modules

import com.example.justtakeanypicture.model.network.*
import org.koin.dsl.module
import retrofit2.Retrofit

//API 삽입
val apiModule = module {
    single { get<Retrofit>().create(AuthAPI::class.java) }
    single { get<Retrofit>().create(EtcAPI::class.java) }
    single { get<Retrofit>().create(GalleryAPI::class.java) }
    single { get<Retrofit>().create(PictureAPI::class.java) }
    single { get<Retrofit>().create(UserAPI::class.java) }
}