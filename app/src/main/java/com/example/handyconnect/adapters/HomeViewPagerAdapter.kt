package com.example.handyconnect.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.example.handyconnect.R

class HomeViewPagerAdapter(var context : Context) : PagerAdapter() {
    private var layoutInflater : LayoutInflater ?= null

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = layoutInflater!!.inflate(R.layout.items_images, container, false)
        container.addView(view)

        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val view = `object` as View
        container.removeView(view)
    }

    override fun getCount(): Int {
        return 4
    }

    override fun isViewFromObject(view: View, obj: Any): Boolean {
        return view === obj
    }
}