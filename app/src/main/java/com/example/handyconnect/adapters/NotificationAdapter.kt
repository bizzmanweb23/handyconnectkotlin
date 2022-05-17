package com.example.handyconnect.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.handyconnect.R
import com.example.handyconnect.activities.optimizedView.BookAppointmentActivity
import kotlinx.android.synthetic.main.items_appointment.view.*
import kotlinx.android.synthetic.main.items_notifications_two.view.*

class NotificationAdapter(var context : Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var adapter : NotificationAdapterTwo ?= null

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_notifications_two,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        adapter = NotificationAdapterTwo(context)
        holder.itemView.recycleItems.adapter = adapter
    }

    override fun getItemCount() = 2
}