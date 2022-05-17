package com.example.handyconnect.activities.optimizedView.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.handyconnect.R
import com.example.handyconnect.activities.optimizedView.HomeActivity
import com.example.handyconnect.adapters.QuotationAdapter
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.fragment_quotation.*
import kotlinx.android.synthetic.main.fragment_quotation.toolbarSec

class QuotationFragment : Fragment() {
    private var adapter : QuotationAdapter ?= null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quotation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireContext() as HomeActivity).toolbarSec.visibility = View.GONE
        setAdapter()
    }

    private fun setAdapter() {
        adapter = QuotationAdapter(requireContext())
        recycleQuotation.adapter = adapter
    }

}