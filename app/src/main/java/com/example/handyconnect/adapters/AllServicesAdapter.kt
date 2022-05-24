package com.example.handyconnect.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.handyconnect.R
import com.example.handyconnect.activities.optimizedView.ShowServiceDataActivity
import com.example.handyconnect.model.ServicesModel
import kotlinx.android.synthetic.main.items_allservices.view.*

class AllServicesAdapter(var context: Context,val list: ArrayList<ServicesModel>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_allservices,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        holder.itemView.imagePaint.setImageResource(list[position].image)
        holder.itemView.tvHeading.setText(list[position].title)

        holder.itemView.mainView.setOnClickListener {
            context.startActivity(
                Intent(context, ShowServiceDataActivity::class.java)
                .putExtra("titleName",list[position].title))
        }

    }

    override fun getItemCount() = list.size

}