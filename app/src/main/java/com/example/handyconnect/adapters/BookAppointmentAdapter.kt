package com.example.handyconnect.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.handyconnect.R
import com.example.handyconnect.activities.optimizedView.ViewAppointmentActivity
import com.example.handyconnect.openDatePicker
import kotlinx.android.synthetic.main.items_book_appointment.view.*

class BookAppointmentAdapter(var context : Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var adapter : BookAppointmentTwoAdapter ?= null

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_book_appointment,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        adapter = BookAppointmentTwoAdapter(context)
        holder.itemView.recycleItems.adapter = adapter

        holder.itemView.butBook.setOnClickListener {
            context.startActivity(Intent(context,ViewAppointmentActivity::class.java))
        }

        holder.itemView.tvCalender.setOnClickListener {
            openDatePicker(context,holder.itemView.tvCalender)
        }

    }

    override fun getItemCount() = 6

}