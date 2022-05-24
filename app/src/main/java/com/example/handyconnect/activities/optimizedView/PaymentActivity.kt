package com.example.handyconnect.activities.optimizedView

import android.content.Intent
import android.graphics.drawable.GradientDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioGroup
import androidx.core.content.ContextCompat
import com.example.handyconnect.R
import kotlinx.android.synthetic.main.activity_payment.*

class PaymentActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        setBorderColor()
        setClicks()

    }

    private fun setClicks() {

        rbPayNow.setOnClickListener {
            rbPayNow.setChecked(true)
            rbBankTransfer.setChecked(false)
            rbCashPayment.setChecked(false)
        }
        rbBankTransfer.setOnClickListener {
            rbPayNow.setChecked(false)
            rbBankTransfer.setChecked(true)
            rbCashPayment.setChecked(false)
        }
        rbCashPayment.setOnClickListener {
            rbPayNow.setChecked(false)
            rbBankTransfer.setChecked(false)
            rbCashPayment.setChecked(true)
        }

        crossImage.setOnClickListener {
            onBackPressed()
        }
        butPayNow.setOnClickListener {
            startActivity(Intent(this, PaymentSubmitActivity::class.java))
        }

    }

    private fun setBorderColor() {
        val drawable = etVPA.background as GradientDrawable
        drawable.setStroke(1,ContextCompat.getColor(this,R.color.dark_gray))
    }

}