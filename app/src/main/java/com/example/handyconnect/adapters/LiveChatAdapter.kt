package com.example.handyconnect.adapters

import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.handyconnect.R
import kotlinx.android.synthetic.main.items_chat.view.*


class LiveChatAdapter(var context : Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_chat,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val drawable = (holder.itemView.firstSec).background as GradientDrawable
        drawable.setStroke(1,ContextCompat.getColor(context,R.color.dark_gray))

        val drawable2 = (holder.itemView.secondSec).background as GradientDrawable
        drawable2.setStroke(1,ContextCompat.getColor(context,R.color.dark_gray))

    }

    override fun getItemCount() = 6
}