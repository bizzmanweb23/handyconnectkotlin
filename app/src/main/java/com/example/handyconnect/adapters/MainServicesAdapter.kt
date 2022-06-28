package com.example.handyconnect.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.handyconnect.R
import com.example.handyconnect.activities.InfoActivity
import com.example.handyconnect.activities.RegisterActivity
import com.example.handyconnect.loadImageCategory
import com.example.handyconnect.network.responses.simpleviewCategory.Category
import com.example.handyconnect.session.SessionNotNull
import kotlinx.android.synthetic.main.items_main_services.view.*

class MainServicesAdapter(var context: Context,val categoryList: ArrayList<Category>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_main_services,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var data = categoryList[position]

        if(data.category_image != null) {
            loadImageCategory(data.category_image,context,holder.itemView.imagePhoto)
        }
        if(data.name != null){
            holder.itemView.titleMessage.setText(data.name)
        }

        holder.itemView.mainSec.setOnClickListener {
            if(SessionNotNull(context).isLogin == true){
                callInfoActivity(data.id,data.name)
            }
            else{
                callRegisterActivity()
            }
        }

    }

    private fun callRegisterActivity() {
        context.startActivity(Intent(context, RegisterActivity::class.java))

    }

    private fun callInfoActivity(id: String, name: String) {
        context.startActivity(Intent(context, InfoActivity::class.java)
            .putExtra("callFrom","callFromMain")
            .putExtra("CategoryID",id)
            .putExtra("CategoryName",name))
    }

    override fun getItemCount() = categoryList.size

//    companion object {
//        var isRegister = false
//    }
}