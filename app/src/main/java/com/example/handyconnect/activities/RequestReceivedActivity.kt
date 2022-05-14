package com.example.handyconnect.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.handyconnect.R
import com.example.handyconnect.activities.optimizedView.HomeActivity
import java.util.*

class RequestReceivedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_request_received)

        Timer().schedule(object : TimerTask(){
            override fun run() {
                if((intent?.extras?.get("call_From") == "callFromHome")){
                    startActivity(Intent(this@RequestReceivedActivity, HomeActivity::class.java))
                    finish()
                }
                else{
                    startActivity(Intent(this@RequestReceivedActivity, MainActivity::class.java))
                    finish()
                }
            }
        },5000)
    }
}