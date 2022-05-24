package com.example.handyconnect.activities.optimizedView.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.handyconnect.R
import com.example.handyconnect.adapters.PointsAdapter
import kotlinx.android.synthetic.main.fragment_point.*


class PointFragment : Fragment() {

    private var adapter : PointsAdapter ?= null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_point, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setAdapter()
    }

    private fun setAdapter() {
        adapter = PointsAdapter(requireContext())
        recyclePoints.adapter = adapter
    }

}