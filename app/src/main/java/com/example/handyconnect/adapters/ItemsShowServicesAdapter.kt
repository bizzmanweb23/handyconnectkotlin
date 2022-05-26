package com.example.handyconnect.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.handyconnect.R
import kotlinx.android.synthetic.main.items_info.view.*

class ItemsShowServicesAdapter(var context: Context,val arrayList: ArrayList<String>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var isSelected = true

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
      //  val view = LayoutInflater.from(parent.context).inflate(R.layout.items_show_service,parent,false)
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_info,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        holder.itemView.tvItem.setText(arrayList[position])

        holder.itemView.mainSection.setOnClickListener {
            if(isSelected) {
                holder.itemView.tvItem.setTextColor(ContextCompat.getColor(context,R.color.heading2_color))
                holder.itemView.img_tick.visibility = View.VISIBLE
                isSelected = false
            }
            else {
                holder.itemView.tvItem.setTextColor(ContextCompat.getColor(context,R.color.heading3_color))
                holder.itemView.img_tick.visibility = View.GONE
                isSelected = true
            }
        }

    }

    override fun getItemCount() = arrayList.size

}