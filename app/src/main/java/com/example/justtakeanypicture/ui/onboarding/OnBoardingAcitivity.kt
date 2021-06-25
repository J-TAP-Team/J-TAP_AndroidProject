package com.example.justtakeanypicture.ui.onboarding

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.justtakeanypicture.R
import com.example.justtakeanypicture.databinding.ActivityOnBoardingAcitivityBinding
import com.example.justtakeanypicture.ui.register.login.LoginActivity
import com.example.justtakeanypicture.ui.onboarding.adapter.OnBoardingAdapter

class OnBoardingAcitivity : AppCompatActivity() {
    private lateinit var binding : ActivityOnBoardingAcitivityBinding
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityOnBoardingAcitivityBinding>(
            this@OnBoardingAcitivity,
            R.layout.activity_on_boarding_acitivity
        )
        binding.viewPagerOnBoarding.adapter = OnBoardingAdapter(supportFragmentManager)
        binding.viewPagerOnBoarding.offscreenPageLimit = 3
        binding.dotsIndicator.setViewPager(binding.viewPagerOnBoarding)

        binding.onboardingButton.setOnClickListener {
            if (binding.viewPagerOnBoarding.currentItem == 3) {
                startActivity(Intent(this,LoginActivity::class.java))
                finish()
            }
            else {
                binding.viewPagerOnBoarding.currentItem = binding.viewPagerOnBoarding.currentItem+1
            }
        }
    }
}