package com.example.justtakeanypicture.base

import android.os.Bundle
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.justtakeanypicture.BR
import androidx.databinding.ViewDataBinding

abstract class BaseActivity <B : ViewDataBinding, VM : BaseViewModel>(
    @LayoutRes private val layoutResId: Int
) : AppCompatActivity() {

    lateinit var binding: B

    abstract val viewModel: VM
    protected abstract fun observerViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutResId)
        binding.setVariable(BR.viewModel, viewModel)
        binding.lifecycleOwner = this
        binding.executePendingBindings()
        observerViewModel()
    }

    fun showToast(message: String) = Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
}