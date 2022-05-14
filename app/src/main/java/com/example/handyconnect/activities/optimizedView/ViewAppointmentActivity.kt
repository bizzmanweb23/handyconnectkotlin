package com.example.handyconnect.activities.optimizedView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.handyconnect.R
import com.example.handyconnect.adapters.ViewAppointmentAdapter
import kotlinx.android.synthetic.main.activity_view_appointment.*

class ViewAppointmentActivity : AppCompatActivity() {
    private var adapter : ViewAppointmentAdapter?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_appointment)

        setAdapter()
    }

    private fun setAdapter() {
        adapter = ViewAppointmentAdapter(this)
        recycleServices.adapter = adapter

    }
}