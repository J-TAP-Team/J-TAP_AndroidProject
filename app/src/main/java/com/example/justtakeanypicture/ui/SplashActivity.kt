package com.example.justtakeanypicture.ui

import android.os.Bundle
import android.os.Handler
import androidx.lifecycle.Observer
import com.example.justtakeanypicture.R
import com.example.justtakeanypicture.base.BaseActivity
import com.example.justtakeanypicture.databinding.ActivitySplashBinding
import com.example.justtakeanypicture.ui.onboarding.OnBoardingAcitivity
import com.example.justtakeanypicture.ui.register.login.LoginActivity
import com.example.justtakeanypicture.ui.register.signup.SignUpActivity
import com.example.justtakeanypicture.viewModel.view.SplashViewModel
import com.example.justtakeanypicture.widget.extension.startActivityWithFinish
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashActivity : BaseActivity<ActivitySplashBinding, SplashViewModel>(
    R.layout.activity_splash
) {
    override val viewModel: SplashViewModel by viewModel()

    override fun observerViewModel() {

        val handler = Handler()
        var runnable: Runnable

        with(viewModel) {
            onSuccessEvent.observe(this@SplashActivity, Observer {
                showToast("Splash 창 연결").let {
                    runnable = Runnable {
                        startActivityWithFinish(
                            applicationContext,
                            MainActivity::class.java
                        )
                    }
                    handler.postDelayed(runnable, 2000)
                }
            })
            onFailEvent.observe(this@SplashActivity, Observer {
                showToast("Splash 창 연결").let {
                    runnable = Runnable {
                        startActivityWithFinish(
                            applicationContext,
                            OnBoardingAcitivity::class.java
                        )
                    }
                    handler.postDelayed(runnable, 2000)
                }
            })
        }
    }

}