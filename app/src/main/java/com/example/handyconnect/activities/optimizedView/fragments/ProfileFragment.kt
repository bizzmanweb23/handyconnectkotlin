package com.example.handyconnect.activities.optimizedView.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.RadioGroup
import androidx.lifecycle.Observer
import com.example.handyconnect.R
import com.example.handyconnect.activities.optimizedView.ProfileActivity
import com.example.handyconnect.activities.optimizedView.HomeActivity
import com.example.handyconnect.session.SessionNotNull
import com.example.handyconnect.utils.isNetworkConnected
import com.example.handyconnect.utils.showToast
import com.example.handyconnect.viewModel.GetProfileVM
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {

    private var profileViewModel : GetProfileVM?= null
    private var loginPref : SessionNotNull ?= null
    var ServiceLocation = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireContext() as HomeActivity).toolbarSec.visibility = View.GONE
        profileViewModel = GetProfileVM()
        loginPref = SessionNotNull(requireContext())

        if(requireActivity().isNetworkConnected()){
            profileViewModel?.getProfileMethod(requireContext(),loginPref?.loginData?.id!!)
        }
        else{
            showToast(requireContext(),"No Internet Connection")
        }

        listeners()
        clicks()



    }

    private fun listeners() {
        profileViewModel?.userGetProfile?.observe(requireActivity(), Observer { user ->
            if(user != null){
                if(user.SuccessCode == 200){
                    if(user.data != null){
                        if(user.data.name != null){
                            tvName.setText(user.data.name)
                        }
                        if(user.data.email != null){
                            tvEmail.setText(user.data.email)
                        }
                        if(user.data.mobile != null){
                            tvMobile.setText(user.data.mobile)
                        }
                        if(user.data.location != null){
                            ServiceLocation = user.data.location
                            tvLocation.setText(user.data.location).toString()
                        }
                    }
                    else{
                        showToast(requireContext(),user.message)
                    }
                }
                else{
                    showToast(requireContext(),"Data error")
                }
            }
            else{
                showToast(requireContext(),"Something went wrong")
            }
        })
    }

    private fun clicks() {
        butEdit.setOnClickListener {
            startActivity(Intent(Intent(requireContext(), ProfileActivity::class.java)))
        }

        checkedItem.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener{
            override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
                if(checkedItem.isChecked){
                    tvServiceLocation.setText(ServiceLocation)
                }
                else{
                    tvServiceLocation.setText("")
                }
            }

        })
    }

}