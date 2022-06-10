package com.example.handyconnect.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.handyconnect.R
import com.example.handyconnect.adapters.MainServicesAdapter
import com.example.handyconnect.network.responses.simpleviewCategory.Category
import com.example.handyconnect.utils.isNetworkConnected
import com.example.handyconnect.utils.showToast
import com.example.handyconnect.viewModel.SimpleViewCategoryVM
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var categoryVM : SimpleViewCategoryVM  ?= null
    private var adapter : MainServicesAdapter ?= null
    var categoryList : ArrayList<Category> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        categoryList.clear()
        categoryVM = SimpleViewCategoryVM()


        if(isNetworkConnected()){
            categoryVM?.simpleViewCategoryMethod(this)
        }
        else{
            showToast(this,"No internet connection")
        }
        clicks()
        listeners()

    }

    private fun setAdapter() {
        adapter = MainServicesAdapter(this,categoryList)
        recycleServices.adapter = adapter
    }

    private fun listeners() {
        categoryVM?.simpleViewCategory?.observe(this, Observer { user ->
            if(user != null){
                if(user.SuccessCode == 200){
                   if(user.data != null){
                       categoryList.addAll(user.data.category)
                       setAdapter()

                   }
                    else{
                        showToast(this,"Error")
                    }
                }
                else{
                    showToast(this,"Error")
                }
            }
            else{
                showToast(this,"Something went wrong")
            }
        })
    }

    private fun clicks() {
      /*  paintingSec.setOnClickListener{
            if(isRegister){
                callInfoActivity()
            }
            else{
                callRegisterActivity()
            }

        }
        doorRepairSec.setOnClickListener {
            if(isRegister){
                callInfoActivity()
            }
            else{
                callRegisterActivity()
            }
        }
        electricalSec.setOnClickListener {
            if(isRegister){
                callInfoActivity()
            }
            else{
                callRegisterActivity()
            }
        }
        airConditionSec.setOnClickListener {
            if(isRegister){
                callInfoActivity()
            }
            else{
                callRegisterActivity()
            }
        }
        carpentrySec.setOnClickListener {
            if(isRegister){
                callInfoActivity()
            }
            else{
                callRegisterActivity()
            }
        }
        furnitureSec.setOnClickListener {
            if(isRegister){
                callInfoActivity()
            }
            else{
                callRegisterActivity()
            }
        }
        cleaningSec.setOnClickListener {
            if(isRegister){
                callInfoActivity()
            }
            else{
                callRegisterActivity()
            }
        }
        installationSec.setOnClickListener {
            if(isRegister){
                callInfoActivity()
            }
            else{
                callRegisterActivity()
            }
        }
        lockSmith.setOnClickListener {
            if(isRegister){
                callInfoActivity()
            }
            else{
                callRegisterActivity()
            }
        }
        drillSec.setOnClickListener {
            if(isRegister){
                callInfoActivity()
            }
            else{
                callRegisterActivity()
            }
        }
        plumbingSec.setOnClickListener {
            if(isRegister){
                callInfoActivity()
            }
            else{
                callRegisterActivity()
            }
        }
        otherSec.setOnClickListener {
            if(isRegister){
                callInfoActivity()
            }
            else{
                callRegisterActivity()
            }
        }
*/
        butBack.setOnClickListener {
            startActivity(Intent(this,SelectOptionActivity::class.java))
            finish()
        }
    }

//    private fun callInfoActivity() {
//        startActivity(Intent(this, InfoActivity::class.java)
//            .putExtra("callFrom","callFromMain"))
//    }
//
//    private fun callRegisterActivity() {
//        startActivity(Intent(this, RegisterActivity::class.java))
//    }


}