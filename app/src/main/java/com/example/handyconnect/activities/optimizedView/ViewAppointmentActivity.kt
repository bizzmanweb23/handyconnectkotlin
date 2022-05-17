package com.example.handyconnect.activities.optimizedView

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.handyconnect.R
import com.example.handyconnect.activities.RequestReceivedActivity
import com.example.handyconnect.adapters.ViewAppointmentAdapter
import kotlinx.android.synthetic.main.activity_view_appointment.*

class ViewAppointmentActivity : AppCompatActivity() {
    private var adapter : ViewAppointmentAdapter?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_appointment)

        setAdapter()
        clicks()
    }

    private fun clicks() {
        butConfirmAppointment.setOnClickListener {
            startActivity(Intent(this, RequestReceivedActivity::class.java)
                .putExtra("call_From","callFromHome"))
        }
        butBack.setOnClickListener {
            onBackPressed()
        }
    }

    private fun setAdapter() {
        adapter = ViewAppointmentAdapter(this)
        recycleServices.adapter = adapter

    }
}