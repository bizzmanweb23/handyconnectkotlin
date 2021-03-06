package com.example.handyconnect.activities.optimizedView.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.handyconnect.R
import com.example.handyconnect.activities.InfoActivity
import com.example.handyconnect.activities.RegisterActivity
import com.example.handyconnect.activities.optimizedView.AllServicesActivity
import com.example.handyconnect.activities.optimizedView.HomeActivity
import com.example.handyconnect.adapters.HomeViewPagerAdapter
import com.example.handyconnect.adapters.OurWorksAdapter
import com.example.handyconnect.session.SessionNotNull
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {
    private var adapter : HomeViewPagerAdapter ?= null
    private var workAdapter : OurWorksAdapter ?= null
    private var loginPref : SessionNotNull ?= null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle? ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loginPref = SessionNotNull(requireContext())
        (requireContext() as HomeActivity).toolbarSec.visibility = View.VISIBLE

        setViewPagerAdapter()
        setAdapter()
        clicks()
    }

    private fun clicks() {
        butSeeAll.setOnClickListener {
            startActivity(Intent(requireContext(),AllServicesActivity::class.java))

        }
        paintingSec.setOnClickListener {
            if(loginPref?.isLogin == true){
                callInfoActivity()
            }
            else{
                callRegisterActivity()
            }
        }
        doorRepairSec.setOnClickListener {
            if(loginPref?.isLogin == true){
                callInfoActivity()
            }
            else{
                callRegisterActivity()
            }
        }
        electricalSec.setOnClickListener {
            if(loginPref?.isLogin == true){
                callInfoActivity()
            }
            else{
                callRegisterActivity()
            }
        }
        plumbingSec.setOnClickListener {
            if(loginPref?.isLogin == true){
                callInfoActivity()
            }
            else{
                callRegisterActivity()
            }
        }
    }

    private fun callInfoActivity() {
        startActivity(Intent(requireContext(), InfoActivity::class.java)
            .putExtra("callFrom","callFromHome"))
    }

    private fun callRegisterActivity() {
        startActivity(Intent(requireContext(), RegisterActivity::class.java))
    }

    private fun setAdapter() {
        workAdapter = OurWorksAdapter(requireContext())
        recycleWorks.adapter = workAdapter
    }

    private fun setViewPagerAdapter() {
        adapter = HomeViewPagerAdapter(requireContext())
        viewPagerHome.adapter = adapter
        dotIndicatorHome.viewPager = viewPagerHome
    }

}