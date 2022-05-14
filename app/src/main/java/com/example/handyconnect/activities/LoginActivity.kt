package com.example.handyconnect.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.handyconnect.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        clicks()
    }

    private fun clicks() {
        butBack.setOnClickListener {
            onBackPressed()
        }
        butLogin.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
        tvForgetPass.setOnClickListener {
            startActivity(Intent(this,ForgotPasswordActivity::class.java))
        }
    }
}