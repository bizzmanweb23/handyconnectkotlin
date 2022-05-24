package com.example.handyconnect.activities.optimizedView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.handyconnect.R
import com.example.handyconnect.adapters.AllServicesAdapter
import com.example.handyconnect.model.ServicesModel
import kotlinx.android.synthetic.main.activity_all_services.*

class AllServicesActivity : AppCompatActivity() {

    private var adapter : AllServicesAdapter ?= null
    private var list : ArrayList<ServicesModel> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_services)

        list.clear()
        list.add(ServicesModel(R.drawable.paint_roller,getString(R.string.cap_painting)))
        list.add(ServicesModel(R.drawable.opendoor,getString(R.string.cap_doorrepair)))
        list.add(ServicesModel(R.drawable.electricalservice,getString(R.string.cap_electrical)))
        list.add(ServicesModel(R.drawable.waterheater,getString(R.string.cap_waterheater)))
        list.add(ServicesModel(R.drawable.hammer,getString(R.string.cap_carpentry)))
        list.add(ServicesModel(R.drawable.grabs,getString(R.string.cap_grabars)))
        list.add(ServicesModel(R.drawable.disinfectant,getString(R.string.cap_disinfrction_sanitation)))
        list.add(ServicesModel(R.drawable.tvshow,getString(R.string.cap_tv_bracket_install)))
        list.add(ServicesModel(R.drawable.lockwhite,getString(R.string.cap_locksmith)))
        list.add(ServicesModel(R.drawable.furnitureimg,getString(R.string.cap_furniture_assembly)))
        list.add(ServicesModel(R.drawable.drillingimg,getString(R.string.cap_drilling)))
        list.add(ServicesModel(R.drawable.plumbimgwhite,getString(R.string.cap_plumbing)))
        list.add(ServicesModel(R.drawable.wallmounting,getString(R.string.cap_wall_mounting)))

        setAdapter()
        clicks()
    }

    private fun clicks() {
        butBack.setOnClickListener {
            onBackPressed()
        }
    }

    private fun setAdapter() {
        adapter = AllServicesAdapter(this,list)
        recycleAllServices.adapter = adapter
    }

}