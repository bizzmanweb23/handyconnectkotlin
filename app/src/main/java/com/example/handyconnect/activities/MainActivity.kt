package com.example.handyconnect.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.handyconnect.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        clicks()

    }

    private fun clicks() {
        paintingSec.setOnClickListener{
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

        butBack.setOnClickListener {
            startActivity(Intent(this,SelectOptionActivity::class.java))
            finish()
        }
    }

    private fun callInfoActivity() {
        startActivity(Intent(this, InfoActivity::class.java)
            .putExtra("callFrom","callFromMain"))
    }

    private fun callRegisterActivity() {
        startActivity(Intent(this, RegisterActivity::class.java))
    }

    companion object {
        var isRegister = false
    }
}