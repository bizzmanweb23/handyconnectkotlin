package com.example.handyconnect.activities

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import com.example.handyconnect.R
import com.example.handyconnect.adapters.MainServicesAdapter.Companion.isRegister
import com.example.handyconnect.session.SessionNotNull
import com.example.handyconnect.utils.isEmailValid
import com.example.handyconnect.utils.isNetworkConnected
import com.example.handyconnect.utils.showToast
import com.example.handyconnect.viewModel.RegisterViewModel
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.otp_verification_popup.*
import java.util.*

class RegisterActivity : AppCompatActivity() {
    private var registerModel : RegisterViewModel ?= null
    private var loginPref : SessionNotNull ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        registerModel = RegisterViewModel()
        loginPref = SessionNotNull(this)

        clicks()
        listeners()

    }

    private fun listeners() {
        registerModel?.userRegister?.observe(this, androidx.lifecycle.Observer { user ->
            if(user != null){
                if(user.SuccessCode == 200) {
                    loginPref?.loginData = user.Data
                    loginPref?.isLogin = true
                    showToast(this, user.Message)
                    showOtpVerificationPopup()
                }
            }
            else {
                showToast(this,"Something went wrong")
            }
        })
    }

    private fun clicks() {
        butRegister.setOnClickListener {
            if(!isNetworkConnected()){
                showToast(this,"Please check internet connection")
            }else {
                if (etName.text.toString().isEmpty()) {
                    showToast(this, "Please enter name")
                } else if (!isEmailValid(etEmail.text.toString().trim())) {
                    showToast(this, "Please enter valid email")
                } else if (etEmail.text.toString().isEmpty()) {
                    showToast(this, "Please enter email")
                } else if (etPhone.text.toString().isEmpty()) {
                    showToast(this, "Please enter phone number")
                } else if (etLocation.text.toString().isEmpty()) {
                    showToast(this, "Please enter location")
                } else if (etPassword.text.toString().length < 6) {
                    showToast(this, "Password length should not be less than 6 characters")
                } else if (etRePassword.text.toString().isEmpty()) {
                    showToast(this, "Please enter re_enter password")
                } else if (etPassword.text.toString() != etRePassword.text.toString()) {
                    showToast(this, "Password and Confirm Password should be same")
                } else {
                    registerModel?.userRegister(
                        this,
                        etName.text.toString(),
                        etEmail.text.toString(),
                        etPhone.text.toString(),
                        etLocation.text.toString(),
                        etPassword.text.toString(),
                        etRePassword.text.toString()
                    )
                }
            }

        }
        butBack.setOnClickListener {
            onBackPressed()
        }
//        tvSignIn.setOnClickListener {
//            startActivity(Intent(this,LoginActivity::class.java))
//        }


    }

    private fun showOtpVerificationPopup() {
        var dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.otp_verification_popup)

        dialog.butOtpSend.setOnClickListener {
            isRegister = true
            dialog.dismiss()
            showDialog()
        }

        dialog.show()
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));


    }


    private fun showDialog() {
        var dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.thanku_popup)

        dialog.show()
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));

        Timer().schedule(object : TimerTask(){
            override fun run() {
                dialog.dismiss()
            }

        },5000)

        dialog.setOnDismissListener {
            onBackPressed()
        }

    }

}