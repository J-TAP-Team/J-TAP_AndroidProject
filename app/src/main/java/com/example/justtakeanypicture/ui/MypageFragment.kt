package com.example.justtakeanypicture.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.justtakeanypicture.R
import com.example.justtakeanypicture.databinding.FragmentMypageBinding
import com.example.justtakeanypicture.viewModel.MainViewModel
import com.example.justtakeanypicture.viewModel.MyPageFragmentViewModel
import kr.hs.dgsw.stac.semo.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel


class MypageFragment : BaseFragment<FragmentMypageBinding, MyPageFragmentViewModel>(
        R.layout.fragment_mypage
) {


    override val viewModel: MyPageFragmentViewModel by viewModel()

    override fun observerViewModel() {

    }

}