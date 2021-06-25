package com.example.justtakeanypicture.ui.register.signup

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import cn.pedant.SweetAlert.SweetAlertDialog
import com.example.justtakeanypicture.R
import com.example.justtakeanypicture.base.BaseActivity
import com.example.justtakeanypicture.databinding.ActivitySignupBinding
import com.example.justtakeanypicture.ui.register.login.LoginActivity
import com.example.justtakeanypicture.viewModel.view.SignUpViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SignUpActivity : BaseActivity<ActivitySignupBinding,SignUpViewModel>(
    R.layout.activity_signup
) {

    override val viewModel: SignUpViewModel by viewModel()

    @SuppressLint("ResourceAsColor")
    override fun observerViewModel() {

        val span: Spannable = binding.signTextLogin.text as Spannable
        span.setSpan(ForegroundColorSpan(R.color.login_text_blue), 11, 14, Spanned.SPAN_COMPOSING)

        with(viewModel){
            onSuccessEvent.observe(this@SignUpActivity) {
                val dialog = SweetAlertDialog(this@SignUpActivity, SweetAlertDialog.SUCCESS_TYPE)

                dialog.setCancelable(false)

                dialog.setTitleText("회원가입에 성공하였습니다")
                    .setConfirmClickListener {
                        dialog.dismiss()
                        finish()
                    }
                    .show()
            }
            onFailEvent.observe(this@SignUpActivity, {
                val dialog = SweetAlertDialog(this@SignUpActivity, SweetAlertDialog.ERROR_TYPE)

                dialog.setCancelable(false)

                dialog.setTitleText("회원가입에 실패하였습니다")
                    .setConfirmClickListener {
                        dialog.dismiss()
                    }
                    .show()
            })
            onLoginEvent.observe(this@SignUpActivity, {
                startActivity(Intent(applicationContext, LoginActivity::class.java))
            })
            onErrorEvent.observe(this@SignUpActivity, {
                val dialog = SweetAlertDialog(this@SignUpActivity, SweetAlertDialog.ERROR_TYPE)

                dialog.setCancelable(false)

                dialog.setTitleText("오류가 발생하였습니다")
                    .setConfirmClickListener {
                        dialog.dismiss()
                    }
                    .show()
            })
        }
    }
}