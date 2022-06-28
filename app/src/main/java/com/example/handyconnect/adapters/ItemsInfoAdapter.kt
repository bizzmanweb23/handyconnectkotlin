package com.example.handyconnect.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.handyconnect.R
import com.example.handyconnect.clickListeners.ServiceItemClick
import com.example.handyconnect.model.SelectedServiceModel
import kotlinx.android.synthetic.main.items_info.view.*

class ItemsInfoAdapter( var context: Context, val cateDetailList: ArrayList<SelectedServiceModel>,
    val listener: ServiceItemClick ) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var arrayList : ArrayList<String> = ArrayList()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_info,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var listData = cateDetailList[position]

        if(listData.data[position].service_name != null){
            holder.itemView.tvItem.setText(listData.data[position].service_name)
        }

        if(listData.isSelected){
            holder.itemView.tvItem.setTextColor(ContextCompat.getColor(context,R.color.heading2_color))
            holder.itemView.img_tick.visibility = View.VISIBLE
        }
        else{
            holder.itemView.tvItem.setTextColor(ContextCompat.getColor(context,R.color.heading3_color))
            holder.itemView.img_tick.visibility = View.GONE
        }

        holder.itemView.mainSection.setOnClickListener{
            selectedItems(position)

//            if(isSelected){
//                holder.itemView.tvItem.setTextColor(ContextCompat.getColor(context,R.color.heading2_color))
//                holder.itemView.img_tick.visibility = View.VISIBLE
//                isSelected = false
//            }
//            else{
//                holder.itemView.tvItem.setTextColor(ContextCompat.getColor(context,R.color.heading3_color))
//                holder.itemView.img_tick.visibility = View.GONE
//                isSelected = true
//            }

            if(listData.data[position].category_id != null || listData.data[position].id != null) {
                listener.onItemClick(position, listData.data[position].category_id, listData.data[position].id)
            }

        }

    }

    private fun selectedItems(position: Int) {
        for(i in 0 until cateDetailList.size-1){
            if(i == position){

                if(cateDetailList[i].isSelected){
                    cateDetailList[i].isSelected = false
                }
                else{
                    cateDetailList[i].isSelected = true
                    arrayList.add(cateDetailList[i].data[i].id)
                    break
                }

            }
        }
        notifyDataSetChanged()
        Log.d("serviceIdList",arrayList.size.toString())



    }

    override fun getItemCount() = cateDetailList.size

}