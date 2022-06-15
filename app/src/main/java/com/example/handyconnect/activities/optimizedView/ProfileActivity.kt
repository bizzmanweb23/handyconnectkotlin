package com.example.handyconnect.activities.optimizedView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import androidx.lifecycle.Observer
import com.example.handyconnect.R
import com.example.handyconnect.session.SessionNotNull
import com.example.handyconnect.utils.isEmailValid
import com.example.handyconnect.utils.isNetworkConnected
import com.example.handyconnect.utils.showToast
import com.example.handyconnect.viewModel.GetProfileVM
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {
    private var profileViewModel : GetProfileVM?= null
    private var loginPref : SessionNotNull?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        profileViewModel = GetProfileVM()
        loginPref = SessionNotNull(this)

        if(isNetworkConnected()){
            profileViewModel?.getProfileMethod(this,loginPref?.loginData?.id!!)
        }
        else{
            showToast(this,"No Internet Connection")
        }

        clicks()
        listeners()
    }

    private fun listeners() {
        profileViewModel?.userGetProfile?.observe(this, Observer { user ->
            if(user != null){
                if(user.SuccessCode == 200){
                    if(user.data != null){
                        if(user.data.name != null){
                            etName.setText(user.data.name)
                            nameText.setText(user.data.name)
                        }
                        if(user.data.email != null){
                            etEmail.setText(user.data.email)
                        }
                        if(user.data.mobile != null){
                            etMobile.setText(user.data.mobile)
                        }
                        if(user.data.location != null){
                            etLocation.setText(user.data.location)
                        }
                    }
                }
                else{
                    showToast(this,user.message)
                }
            }
            else{
               showToast(this,"Something went wrong")
            }
        })

        profileViewModel?.userUpdateProfile?.observe(this, Observer { user ->
            if(user != null){
                if(user.SuccessCode == 200){
                    showToast(this,user.message)
                    onBackPressed()
                }
                else{
                    showToast(this,user.message)
                }
            }
            else{
                showToast(this,"Something went wrong")
            }
        })
    }

    private fun clicks() {

        checkedItem.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener{
            override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
                if(checkedItem.isChecked){
                    servicelocation.setText(etLocation.text.toString())
                }
                else{
                    servicelocation.setText("")
                }
            }

        })

        butBack.setOnClickListener {
            onBackPressed()
        }
        butSave.setOnClickListener {
            if(isNetworkConnected()){
                if(etName.text.toString().isEmpty()){
                    showToast(this,"Please enter name")
                }
                else if(etEmail.text.toString().isEmpty()){
                    showToast(this,"Please enter email")
                }
                else if(!isEmailValid(etEmail.text.toString().trim())){
                    showToast(this,"Please enter valid email")
                }
                else if(etMobile.text.toString().isEmpty()){
                    showToast(this,"Please enter mobile number")
                }
                else if(etLocation.text.toString().isEmpty()){
                    showToast(this,"Please enter location")
                }
                else{
                    profileViewModel?.updateProfileMethod(this,loginPref?.loginData?.id!!,etName.text.toString().trim(),
                    etEmail.text.toString().trim(),etMobile.text.toString().trim(),etLocation.text.toString().trim())
                }
            }
            else{
                showToast(this,"No internet connection")
            }
        }
    }
}