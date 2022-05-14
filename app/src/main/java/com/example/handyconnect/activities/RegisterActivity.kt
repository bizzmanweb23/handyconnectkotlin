package com.example.handyconnect.activities

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.Handler
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import com.example.handyconnect.R
import com.example.handyconnect.activities.MainActivity.Companion.isRegister
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.otp_verification_popup.*
import java.util.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        clicks()

    }

    private fun clicks() {
        butRegister.setOnClickListener {
            showOtpVerificationPopup()

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