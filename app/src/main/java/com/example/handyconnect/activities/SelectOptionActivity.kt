package com.example.handyconnect.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.handyconnect.R
import com.example.handyconnect.activities.optimizedView.HomeActivity
import kotlinx.android.synthetic.main.activity_select_option.*

class SelectOptionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_option)

        clicks()
    }

    private fun clicks() {
        butEngage.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        butExplore.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))

        }

    }
}