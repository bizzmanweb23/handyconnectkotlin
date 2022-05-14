package com.example.handyconnect.activities.optimizedView.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.handyconnect.R
import com.example.handyconnect.activities.MainActivity
import com.example.handyconnect.activities.optimizedView.HomeActivity
import kotlinx.android.synthetic.main.activity_home.*


class AboutUsFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle? ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_about_us, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireContext() as HomeActivity).toolbarSec.visibility = View.GONE
    }

}