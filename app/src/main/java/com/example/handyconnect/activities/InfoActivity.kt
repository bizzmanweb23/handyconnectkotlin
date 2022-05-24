package com.example.handyconnect.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.handyconnect.R
import com.example.handyconnect.adapters.ImagesUploadAdapter
import com.example.handyconnect.adapters.ItemsInfoAdapter
import kotlinx.android.synthetic.main.activity_info.*

class InfoActivity : AppCompatActivity() {

    private var adapter : ItemsInfoAdapter ?= null
    private var imagesAdapter : ImagesUploadAdapter?= null
    var isSelected = true
    var callFrom : String ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        callFrom = intent?.extras?.get("callFrom") as String?

        setAdapter()
        setImagesAdapter()
        clicks()
    }

    private fun clicks() {
        dropdown.setOnClickListener{
            if(isSelected){
                rvItems.visibility = View.VISIBLE
                isSelected = false
            }
            else{
                rvItems.visibility = View.GONE
                isSelected = true
            }
        }

        butBack.setOnClickListener {
            onBackPressed()
        }

        butSubmit.setOnClickListener {
            startActivity(Intent(this, RequestReceivedActivity::class.java)
                .putExtra("call_From",callFrom))
        }
    }

    private fun setImagesAdapter() {
        imagesAdapter = ImagesUploadAdapter(this)
        rvUploadImage.adapter = imagesAdapter
    }

    private fun setAdapter() {
        adapter = ItemsInfoAdapter(this)
        rvItems.adapter = adapter
    }
}