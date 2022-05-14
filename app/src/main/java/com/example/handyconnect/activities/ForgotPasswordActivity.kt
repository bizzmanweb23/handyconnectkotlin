package com.example.handyconnect.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.handyconnect.R
import kotlinx.android.synthetic.main.activity_forgot_password.*

class ForgotPasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        clicks()
    }

    private fun clicks() {
        butBack.setOnClickListener {
            onBackPressed()
        }
        butSend.setOnClickListener {
            startActivity(Intent(this,LoginActivity::class.java))
            finish()
        }

    }
}