package com.example.handyconnect.adapters

import android.content.Context
import android.service.autofill.TextValueSanitizer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.example.handyconnect.R
import com.example.handyconnect.model.IntroscreenModel

class MyViewPagerAdapter(var list : ArrayList<IntroscreenModel>,var context : Context) : PagerAdapter() {
    private var layoutInflater: LayoutInflater? = null


    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = layoutInflater!!.inflate(R.layout.items_introscreens, container, false)
        container.addView(view)

        view.findViewById<TextView>(R.id.tvHead).setText(list.get(position).title)
        view.findViewById<TextView>(R.id.tvDes).setText(list.get(position).des)
        view.findViewById<ImageView>(R.id.imgBanner).setImageResource(list.get(position).image)

        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val view = `object` as View
        container.removeView(view)
    }


    override fun getCount(): Int {
        return list.size
    }

    override fun isViewFromObject(view: View, obj : Any): Boolean {
        return view === obj

    }
}