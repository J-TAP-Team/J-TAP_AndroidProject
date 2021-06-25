package com.example.justtakeanypicture.ui.register.login

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.Spannable
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import cn.pedant.SweetAlert.SweetAlertDialog
import com.example.justtakeanypicture.R
import com.example.justtakeanypicture.base.BaseActivity
import com.example.justtakeanypicture.databinding.ActivityLoginBinding
import com.example.justtakeanypicture.ui.MainActivity
import com.example.justtakeanypicture.ui.register.signup.SignUpActivity
import com.example.justtakeanypicture.viewModel.view.LoginViewModel
import com.example.justtakeanypicture.widget.extension.startActivityWithFinish
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>(
    R.layout.activity_login
) {

    override val viewModel: LoginViewModel by viewModel()


    @SuppressLint("ResourceAsColor")
    override fun observerViewModel() {

        val span: Spannable = binding.loginTextSignUp.text as Spannable
        span.setSpan(ForegroundColorSpan(R.color.login_text_blue), 15, 19, Spanned.SPAN_COMPOSING)

        with(viewModel) {
            onSuccessEvent.observe(this@LoginActivity, {
                val dialog = SweetAlertDialog(this@LoginActivity, SweetAlertDialog.SUCCESS_TYPE)

                dialog.setCancelable(false)

                dialog.setTitleText("로그인에 성공하였습니다")
                    .setConfirmClickListener {
                        dialog.dismiss()
                        startActivityWithFinish(applicationContext, MainActivity::class.java)
                        finish()
                    }
                    .show()
            })
            onFailEvent.observe(this@LoginActivity, {
                val dialog = SweetAlertDialog(this@LoginActivity, SweetAlertDialog.ERROR_TYPE)

                dialog.setCancelable(false)

                dialog.setTitleText("로그인이 실패하였습니다")
                    .setConfirmClickListener {
                        dialog.dismiss()
                    }
                    .show()
            })
            onSignUpEvent.observe(this@LoginActivity, {
                startActivity(Intent(applicationContext, SignUpActivity::class.java))
            })
            onErrorEvent.observe(this@LoginActivity, {
                val dialog = SweetAlertDialog(this@LoginActivity, SweetAlertDialog.ERROR_TYPE)

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