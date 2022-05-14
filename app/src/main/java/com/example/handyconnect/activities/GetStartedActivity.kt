package com.example.handyconnect.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.handyconnect.R
import kotlinx.android.synthetic.main.activity_get_started.*

class GetStartedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_started)

        clicks()
    }

    private fun clicks() {
        butStart.setOnClickListener {
            startActivity(Intent(this,SelectOptionActivity::class.java))
        }
    }
}