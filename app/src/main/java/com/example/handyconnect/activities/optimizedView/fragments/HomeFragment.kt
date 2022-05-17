package com.example.handyconnect.activities.optimizedView.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.handyconnect.R
import com.example.handyconnect.activities.InfoActivity
import com.example.handyconnect.activities.MainActivity
import com.example.handyconnect.activities.RegisterActivity
import com.example.handyconnect.activities.optimizedView.HomeActivity
import com.example.handyconnect.adapters.HomeViewPagerAdapter
import com.example.handyconnect.adapters.OurWorksAdapter
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {
    private var adapter : HomeViewPagerAdapter ?= null
    private var workAdapter : OurWorksAdapter ?= null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle? ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireContext() as HomeActivity).toolbarSec.visibility = View.VISIBLE

        setViewPagerAdapter()
        setAdapter()
        clicks()
    }

    private fun clicks() {
        butSeeAll.setOnClickListener {
            startActivity(Intent(requireContext(),MainActivity::class.java))
        }
        paintingSec.setOnClickListener {
            if(MainActivity.isRegister){
                callInfoActivity()
            }
            else{
                callRegisterActivity()
            }
        }
        doorRepairSec.setOnClickListener {
            if(MainActivity.isRegister){
                callInfoActivity()
            }
            else{
                callRegisterActivity()
            }
        }
        electricalSec.setOnClickListener {
            if(MainActivity.isRegister){
                callInfoActivity()
            }
            else{
                callRegisterActivity()
            }
        }
        plumbingSec.setOnClickListener {
            if(MainActivity.isRegister){
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