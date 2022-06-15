package com.example.handyconnect.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.handyconnect.R
import com.example.handyconnect.clickListeners.ServiceItemClick
import com.example.handyconnect.model.SelectedServiceModel
import com.example.handyconnect.network.responses.categoryServices.CategoryDetailData
import kotlinx.android.synthetic.main.items_info.view.*

class ItemsInfoAdapter(var context: Context,val cateDetailList: ArrayList<CategoryDetailData>,
            val listener : ServiceItemClick ) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var isSelected = true
    var arrayList : ArrayList<SelectedServiceModel> = ArrayList()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_info,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var data = cateDetailList[position]

        if(data.service_name != null){
            holder.itemView.tvItem.setText(data.service_name)
        }

        holder.itemView.mainSection.setOnClickListener{
            if(isSelected){
                holder.itemView.tvItem.setTextColor(ContextCompat.getColor(context,R.color.heading2_color))
                holder.itemView.img_tick.visibility = View.VISIBLE
                isSelected = false

            }
            else{
                holder.itemView.tvItem.setTextColor(ContextCompat.getColor(context,R.color.heading3_color))
                holder.itemView.img_tick.visibility = View.GONE
                isSelected = true
            }

            if(data.category_id != null || data.service_unique_id != null) {
                listener.onItemClick(position, data.category_id, data.id)
            }
        }



    }

    override fun getItemCount() = cateDetailList.size

}