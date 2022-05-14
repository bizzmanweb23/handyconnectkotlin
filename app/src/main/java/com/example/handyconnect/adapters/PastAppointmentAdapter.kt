package com.example.handyconnect.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.handyconnect.R
import kotlinx.android.synthetic.main.items_past_appointment.view.*

class PastAppointmentAdapter(var context : Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var adapter : ItemsToBeServicedAdapter ?= null

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_past_appointment,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        adapter = ItemsToBeServicedAdapter(context)
        holder.itemView.recycleItems.adapter = adapter

    }

    override fun getItemCount() = 4
}