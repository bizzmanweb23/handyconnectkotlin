package com.example.handyconnect.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.handyconnect.R
import com.example.handyconnect.session.SessionNotNull
import com.example.handyconnect.utils.isEmailValid
import com.example.handyconnect.utils.isNetworkConnected
import com.example.handyconnect.utils.showToast
import com.example.handyconnect.viewModel.RegisterViewModel
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    private var loginViewModel : RegisterViewModel ?= null
   // private var loginPref : SessionNotNull ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginViewModel = RegisterViewModel()
    //    loginPref = SessionNotNull(this)

        clicks()
        listeners()
    }

    private fun listeners() {
        loginViewModel?.userLogin?.observe(this, Observer { user ->
            if(user != null){
                if(user.SuccessCode == 200){
                    startActivity(Intent(this,MainActivity::class.java))
                    finish()
                }
            }
            else{
                showToast(this,"Something went wrong")
            }

        })
    }

    private fun clicks() {
        butBack.setOnClickListener {
            onBackPressed()
        }
        butLogin.setOnClickListener {
            if(!isNetworkConnected()){
                showToast(this,"Please check internet connection")
            }
            else{
                if (etEmail.text.toString().isEmpty()) {
                    showToast(this, "Please enter email")
                }
                else if (etPassword.text.toString().isEmpty()) {
                    showToast(this, "Please enter password")
                }
                else{
                    loginViewModel?.userLogin(this,etEmail.text.toString(),etPassword.text.toString())
                }
            }

        }
        tvForgetPass.setOnClickListener {
            startActivity(Intent(this,ForgotPasswordActivity::class.java))
        }
    }
}