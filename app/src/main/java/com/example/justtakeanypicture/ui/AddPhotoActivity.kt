package com.example.justtakeanypicture.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.justtakeanypicture.R
import com.example.justtakeanypicture.base.BaseActivity
import com.example.justtakeanypicture.databinding.ActivityAddPhotoBinding
import com.example.justtakeanypicture.viewModel.AddPhotoViewModel
import com.example.justtakeanypicture.viewModel.view.SignUpViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class AddPhotoActivity : BaseActivity<ActivityAddPhotoBinding,AddPhotoViewModel>(
    R.layout.activity_add_photo
) {
    override val viewModel: AddPhotoViewModel by viewModel()

    override fun observerViewModel() {

    }
}