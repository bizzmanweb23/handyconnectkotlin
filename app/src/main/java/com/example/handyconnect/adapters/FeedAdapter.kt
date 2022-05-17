package com.example.handyconnect.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.handyconnect.R
import kotlinx.android.synthetic.main.items_feeds.view.*


class FeedAdapter(var context : Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var selectedPosition = -1
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_feeds,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(selectedPosition == position){
            holder.itemView.imgThumb.setImageResource(R.drawable.thumbs_up)
        }
        else{
            holder.itemView.imgThumb.setImageResource(R.drawable.grey_thumbs)
        }
        holder.itemView.imgThumb.setOnClickListener {
            selectedPosition = position
            notifyDataSetChanged()

        }



    }

    override fun getItemCount() = 6
}