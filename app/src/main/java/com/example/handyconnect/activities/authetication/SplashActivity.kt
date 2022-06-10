package com.example.handyconnect.activities.authetication

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.handyconnect.R
import com.example.handyconnect.activities.SelectLanguageActivity
import com.example.handyconnect.session.SessionNotNull

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val handler = Handler()
        handler.postDelayed({
            if(SessionNotNull(this).isLogin == true) {
                startActivity(Intent(this, SelectLanguageActivity::class.java))
                finish()
            }
            else
            {
                startActivity(Intent(this, IntroActivity::class.java))
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
//                    finishAffinity()
//                }
//                else {
//                    finish()
//                }
            }

        }, 3000)
    }
}