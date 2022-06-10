package com.example.handyconnect.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.handyconnect.R
import com.example.handyconnect.activities.optimizedView.BookAppointmentActivity
import com.example.handyconnect.network.responses.appointmentList.AppointmentSubList
import com.example.handyconnect.network.responses.appointmentListNew.AppointmentSubListNew
import kotlinx.android.synthetic.main.items_appointment.view.*

class AppointmentAdapter(
    var context: Context,
    val appointmentList: ArrayList<AppointmentSubListNew>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_appointment,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        var data = appointmentList[position]

        if(data.name != null) {
            holder.itemView.serviceName.setText(data.name)
        }

        holder.itemView.tvViewAppointment.setOnClickListener {
            context.startActivity(Intent(context, BookAppointmentActivity::class.java))
        }

    }

    override fun getItemCount() = appointmentList.size

}