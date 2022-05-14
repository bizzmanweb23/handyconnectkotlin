package com.example.handyconnect.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.handyconnect.R
import com.example.handyconnect.activities.optimizedView.BookAppointmentActivity
import kotlinx.android.synthetic.main.items_appointment.view.*
import kotlinx.android.synthetic.main.items_tobeserviced.view.*

class BookAppointmentTwoAdapter(var context : Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_tobeserviced,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        holder.itemView.viewLine.visibility = View.GONE
        holder.itemView.tvItem.setTextColor(ContextCompat.getColor(context,R.color.heading2_color))

    }

    override fun getItemCount() = 6
}