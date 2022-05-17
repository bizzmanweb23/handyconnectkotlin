package com.example.handyconnect.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.handyconnect.R
import com.example.handyconnect.adapters.NotificationAdapter
import kotlinx.android.synthetic.main.activity_notification.*

class NotificationActivity : AppCompatActivity() {
    private var adapter : NotificationAdapter ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)

        setAdapter()
        clicks()
    }

    private fun clicks() {
        butBack.setOnClickListener {
            onBackPressed()
        }
    }

    private fun setAdapter() {
        adapter = NotificationAdapter(this)
        recycleNotifications.adapter = adapter
    }
}