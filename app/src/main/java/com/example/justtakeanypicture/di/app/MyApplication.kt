package com.example.justtakeanypicture.di.app

import android.app.Application
import com.example.justtakeanypicture.di.modules.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {
    companion object {
        //Retrofit URL
        const val BASE_URL = "https://1796f5c23417.ngrok.io"
    }

    override fun onCreate() {
        super.onCreate()

        //Koin 모듈 삽입
        startKoin {
            androidContext(this@MyApplication)
            modules (activityModule)
            modules(apiModule)
            modules(appModule)
            modules(networkModule)
        }
    }
}