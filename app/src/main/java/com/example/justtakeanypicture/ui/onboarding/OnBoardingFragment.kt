package com.example.justtakeanypicture.ui.onboarding

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.example.justtakeanypicture.R
import com.example.justtakeanypicture.databinding.FragmentOnBoardingBinding


class OnBoardingFragment(val index: Int) : Fragment() {

    private lateinit var binding: FragmentOnBoardingBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_on_boarding, container, false)
        return binding.root!!
    }

    @SuppressLint("ResourceAsColor")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (index==0) {
            binding.fragmentOnboardingText.text = "일단\n아무 사진이나\n찍으세요"
            Glide.with(this).load(R.drawable.camera_image).into(binding.fragmentOnboardingLogo)
        } else if (index == 1) {
            binding.fragmentOnboardingText.text = "나만의\n미술관을\n만들어보세요"
            Glide.with(this).load(R.drawable.canvasimage).into(binding.fragmentOnboardingLogo)
        } else if (index == 2) {
            binding.fragmentOnboardingText.text = "다른 사람의\n미술관을\n구경해보세요"
            Glide.with(this).load(R.drawable.artgalleryimage).into(binding.fragmentOnboardingLogo)
        } else {
            binding.fragmentOnboardingText.text = "테마를 사용하여\n최고의 미술관으로\n거듭나보세요"
            Glide.with(this).load(R.drawable.wallpagerimage).into(binding.fragmentOnboardingLogo)
        }
    }
}