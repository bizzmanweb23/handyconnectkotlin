package com.example.handyconnect.activities.optimizedView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.handyconnect.R
import com.example.handyconnect.adapters.LiveChatAdapter
import kotlinx.android.synthetic.main.activity_live_chat.*

class LiveChatActivity : AppCompatActivity() {
    private var adapter : LiveChatAdapter ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_chat)

        setAdapter()
        clicks()
    }

    private fun clicks() {
        butBack.setOnClickListener {
            onBackPressed()
        }
    }

    private fun setAdapter() {
        adapter = LiveChatAdapter(this)
        recycleChat.adapter = adapter
    }
}