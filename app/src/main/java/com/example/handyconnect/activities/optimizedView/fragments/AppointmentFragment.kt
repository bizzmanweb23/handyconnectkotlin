package com.example.handyconnect.activities.optimizedView.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.get
import com.example.handyconnect.R
import com.example.handyconnect.activities.optimizedView.HomeActivity
import com.example.handyconnect.adapters.AppointmentAdapter
import com.example.handyconnect.adapters.PastAppointmentAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_appointment.*

class AppointmentFragment : Fragment() {

    private var adapter : AppointmentAdapter ?= null
    private var pastAdapter : PastAppointmentAdapter?= null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle? ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_appointment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireContext() as HomeActivity).toolbarSec.visibility = View.GONE

        setAppointmentAdapter()
        setTablayouts()
        clicks()
    }

    private fun clicks() {
        butBack.setOnClickListener {
            tabLayout.getTabAt(0)?.select()
            pastAppointmentToolbar.visibility = View.GONE
            toolbarSec.visibility = View.VISIBLE
            setAppointmentAdapter()
        }
    }

    private fun setTablayouts() {
        tabLayout.addOnTabSelectedListener(object  : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when(tab?.position){
                    0 ->{
                        pastAppointmentToolbar.visibility = View.GONE
                        toolbarSec.visibility = View.VISIBLE
                        setAppointmentAdapter()
                    }
                    1 ->{
                        pastAppointmentToolbar.visibility = View.VISIBLE
                        toolbarSec.visibility = View.GONE
                        setPostAppointmentAdapter()
                    }
                }
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        })
    }

    private fun setPostAppointmentAdapter() {
        pastAdapter = PastAppointmentAdapter(requireContext())
        recycleAppointment.adapter = pastAdapter
    }

    private fun setAppointmentAdapter() {
        adapter = AppointmentAdapter(requireContext())
        recycleAppointment.adapter = adapter
    }

}