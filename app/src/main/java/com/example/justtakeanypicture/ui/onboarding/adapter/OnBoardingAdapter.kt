package com.example.justtakeanypicture.ui.onboarding.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.justtakeanypicture.ui.onboarding.OnBoardingFragment

class OnBoardingAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int): Fragment {
        return OnBoardingFragment(position)
    }

    override fun getCount() =  4
}