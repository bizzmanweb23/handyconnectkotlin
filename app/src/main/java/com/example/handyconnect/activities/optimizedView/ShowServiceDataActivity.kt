package com.example.handyconnect.activities.optimizedView

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.handyconnect.R
import com.example.handyconnect.activities.InfoActivity
import com.example.handyconnect.adapters.ItemsShowServicesAdapter
import kotlinx.android.synthetic.main.activity_show_service_data.*

class ShowServiceDataActivity : AppCompatActivity() {

    private var adapter : ItemsShowServicesAdapter ?= null
    var arrayList : ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_service_data)

        arrayList.clear()

        tvServiceName.setText(intent?.extras?.get("titleName") as String)

        if(tvServiceName.text.toString().equals(getString(R.string.cap_painting))){
            arrayList.add("ONE ROOM")
            arrayList.add("ONE HALL")
            arrayList.add("ONE HALL")
            arrayList.add("ONE HALL")
            arrayList.add("ONE HALL")
            arrayList.add("ONE HALL")
            arrayList.add("ONE HALL")
            arrayList.add("ONE HALL")
            arrayList.add("ONE HALL")
            arrayList.add("ONE HALL")
            arrayList.add("ONE HALL")
            arrayList.add("ONE HALL")
            arrayList.add("ONE HALL")
            arrayList.add("ONE HALL")
            arrayList.add("ONE HALL")
            arrayList.add("ONE HALL")
            arrayList.add("ONE HALL")
            arrayList.add("ONE HALL")
            arrayList.add("ONE HALL")
            arrayList.add("ONE HALL")
            arrayList.add("ONE HALL")
        }
        else if(tvServiceName.text.toString().equals(getString(R.string.cap_doorrepair))){
            arrayList.add("DOOR LOCK REPLACEMENT")
            arrayList.add("GATE LOCK REPLACEMENT")
            arrayList.add("DOOR HANDLE REPLACEMENT")
            arrayList.add("DOOR HANDLE REPLACEMENT")
            arrayList.add("DOOR HANDLE REPLACEMENT")
            arrayList.add("DOOR HANDLE REPLACEMENT")
            arrayList.add("DOOR HANDLE REPLACEMENT")
            arrayList.add("DOOR HANDLE REPLACEMENT")
        }
        else if(tvServiceName.text.toString().equals(getString(R.string.cap_electrical))){
            arrayList.add("INSTALL WALL FAN")
            arrayList.add("INSTALL CEILING FAN")
            arrayList.add("INSTALL AIRCON POINT")
            arrayList.add("INSTALL AIRCON POINT")
            arrayList.add("INSTALL AIRCON POINT")
            arrayList.add("INSTALL AIRCON POINT")
            arrayList.add("INSTALL AIRCON POINT")
            arrayList.add("INSTALL AIRCON POINT")
            arrayList.add("INSTALL AIRCON POINT")
        }
        else if(tvServiceName.text.toString().equals(getString(R.string.cap_waterheater))){
            arrayList.add("INSTALL/REPLACE STORAGE HEATER")
            arrayList.add("INSTALL/REPLACE INSTANT HEATER")
            arrayList.add("INSTALL/REPLACE INSTANT HEATER")
            arrayList.add("INSTALL/REPLACE INSTANT HEATER")
            arrayList.add("INSTALL/REPLACE INSTANT HEATER")
            arrayList.add("INSTALL/REPLACE INSTANT HEATER")
            arrayList.add("INSTALL/REPLACE INSTANT HEATER")
        }
        else if(tvServiceName.text.toString().equals(getString(R.string.cap_carpentry))){
            arrayList.add("CUSTOMISATION OF CARPENTRY WORK")
            arrayList.add("CUSTOMISATION OF CARPENTRY WORK")
            arrayList.add("CUSTOMISATION OF CARPENTRY WORK")
            arrayList.add("CUSTOMISATION OF CARPENTRY WORK")
            arrayList.add("CUSTOMISATION OF CARPENTRY WORK")
            arrayList.add("CUSTOMISATION OF CARPENTRY WORK")
            arrayList.add("CUSTOMISATION OF CARPENTRY WORK")
        }
        else if(tvServiceName.text.toString().equals(getString(R.string.cap_grabars))){
            arrayList.add("ONE ROOM")
            arrayList.add("ONE ROOM")
            arrayList.add("ONE ROOM")
            arrayList.add("ONE ROOM")
            arrayList.add("ONE ROOM")
            arrayList.add("ONE ROOM")
            arrayList.add("ONE ROOM")
        }
        else if(tvServiceName.text.toString().equals(getString(R.string.cap_disinfrction_sanitation))){
            arrayList.add("3-ROOM")
            arrayList.add("4-ROOM")
            arrayList.add("5-ROOM")
            arrayList.add("LANDED HOUSES")
            arrayList.add("LANDED HOUSES")
            arrayList.add("LANDED HOUSES")
            arrayList.add("LANDED HOUSES")
            arrayList.add("LANDED HOUSES")
            arrayList.add("LANDED HOUSES")
        }
        else if(tvServiceName.text.toString().equals(getString(R.string.cap_tv_bracket_install))){
            arrayList.add("-------------")
            arrayList.add("-------------")
        }
        else if(tvServiceName.text.toString().equals(getString(R.string.cap_locksmith))){
            arrayList.add("UNLOCKING DOOR")
            arrayList.add("UNLOCKING DOOR")
            arrayList.add("UNLOCKING DOOR")
            arrayList.add("UNLOCKING DOOR")
            arrayList.add("UNLOCKING DOOR")
            arrayList.add("UNLOCKING DOOR")
            arrayList.add("UNLOCKING DOOR")
            arrayList.add("UNLOCKING DOOR")
        }
        else if(tvServiceName.text.toString().equals(getString(R.string.cap_furniture_assembly))){
            arrayList.add("SHELF ASSEMBLY (UP TO 3 SHELVES)")
            arrayList.add("SHELF ASSEMBLY (UP TO 3 SHELVES)")
            arrayList.add("SHELF ASSEMBLY (UP TO 3 SHELVES)")
            arrayList.add("SHELF ASSEMBLY (UP TO 3 SHELVES)")

        }
        else if(tvServiceName.text.toString().equals(getString(R.string.cap_drilling))){
            arrayList.add("HANG PHOTO/ARTWORK")
            arrayList.add("HANG MIRROR")
            arrayList.add("INSTALL BATHROOM ACCESSORIES")
            arrayList.add("INSTALL PULL-UP BAR")
            arrayList.add("INSTALL PULL-UP BAR")
            arrayList.add("INSTALL PULL-UP BAR")
            arrayList.add("INSTALL PULL-UP BAR")
        }
        else if(tvServiceName.text.toString().equals(getString(R.string.cap_plumbing))){
            arrayList.add("SUPPLY & INSTALL TOILET BOWL SET")
            arrayList.add("SUPPLY & INSTALL TOILET BOWL SET")
            arrayList.add("SUPPLY & INSTALL TOILET BOWL SET")
            arrayList.add("SUPPLY & INSTALL TOILET BOWL SET")
        }
        else{
              arrayList.add("------------------")
              arrayList.add("------------------")

        }
        clicks()
        setAdapter()

    }

    private fun setAdapter() {
        adapter = ItemsShowServicesAdapter(this,arrayList)
        recycleServiceInfo.adapter = adapter
    }

    private fun clicks() {
        butContinue.setOnClickListener {
            startActivity(Intent(this,InfoActivity::class.java)
                .putExtra("callFrom","callFromHome"))
        }
        butBack.setOnClickListener {
            onBackPressed()
        }
    }
}