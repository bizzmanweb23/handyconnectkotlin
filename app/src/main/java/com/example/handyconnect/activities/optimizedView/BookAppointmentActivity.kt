package com.example.handyconnect.activities.optimizedView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.handyconnect.R
import com.example.handyconnect.adapters.BookAppointmentAdapter
import kotlinx.android.synthetic.main.activity_book_appointment.*

class BookAppointmentActivity : AppCompatActivity() {

    private var adapter : BookAppointmentAdapter ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_appointment)

        setAdapter()
    }

    private fun setAdapter() {
        adapter = BookAppointmentAdapter(this)
        recycleBookAppointment.adapter = adapter
    }
}