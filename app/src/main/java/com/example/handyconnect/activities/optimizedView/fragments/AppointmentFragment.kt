package com.example.handyconnect.activities.optimizedView.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.handyconnect.R
import com.example.handyconnect.activities.optimizedView.HomeActivity
import com.example.handyconnect.adapters.AppointmentAdapter
import com.example.handyconnect.adapters.PastAppointmentAdapter
import com.example.handyconnect.network.responses.appointmentListNew.AppointmentSubListNew
import com.example.handyconnect.session.SessionNotNull
import com.example.handyconnect.utils.isNetworkConnected
import com.example.handyconnect.utils.showToast
import com.example.handyconnect.viewModel.AppointmentListViewModel
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_appointment.*

class AppointmentFragment : Fragment() {

    private var adapter : AppointmentAdapter ?= null
    private var pastAdapter : PastAppointmentAdapter?= null
    private var appointVM : AppointmentListViewModel ?= null
    var appointmentList  : ArrayList<AppointmentSubListNew> = ArrayList()

    private var loginPref : SessionNotNull ?= null

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle? ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_appointment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        appointmentList.clear()
        (requireContext() as HomeActivity).toolbarSec.visibility = View.GONE
        appointVM = AppointmentListViewModel()
        loginPref = SessionNotNull(requireContext())

        if(requireActivity().isNetworkConnected()){
            appointVM?.appointmentListMethod(requireContext())
        }
        else{
            showToast(requireContext(),"No internet connection")
        }



        listeners()

        setTablayouts()
        clicks()

    }

    private fun listeners() {
        appointVM?.appointmentList?.observe(requireActivity(), Observer { user ->
            if(user != null){
                if(user.SuccessCode == 200){
                    if(user.data != null){
                        appointmentList.addAll(user.data)
                    }
                    setAppointmentAdapter()

                }
                else{
                    showToast(requireContext(),user.massage)
                }
            }
            else{
                showToast(requireContext(),"Something went wrong")
            }
        })

        appointVM?.pastAppointmentList?.observe(requireActivity(), Observer { user ->
            if(user != null){
                if(user.success == 200){
                    showToast(requireContext(),user.massage)
                }
                else{
                    showToast(requireContext(),user.massage)
                }
            }
            else{
                showToast(requireContext(),"Something went wrong")
            }
        })
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
                        if(requireActivity().isNetworkConnected()){
                            appointVM?.appointmentListMethod(requireContext())
                        }
                        else{
                            showToast(requireContext(),"No internet connection")
                        }

                      //  setAppointmentAdapter()
                    }
                    1 ->{
                        pastAppointmentToolbar.visibility = View.VISIBLE
                        toolbarSec.visibility = View.GONE

                        if(requireActivity().isNetworkConnected()){
                            appointVM?.pastAppointmentListMethod(requireContext(),loginPref?.loginData?.id!!)
                        }
                        else{
                            showToast(requireContext(),"No internet connection")
                        }
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
        adapter = AppointmentAdapter(requireContext(),appointmentList)
        recycleAppointment.adapter = adapter
    }


}