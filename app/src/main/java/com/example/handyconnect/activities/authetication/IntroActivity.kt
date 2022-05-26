package com.example.handyconnect.activities.authetication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.handyconnect.R
import com.example.handyconnect.activities.SelectLanguageActivity
import com.example.handyconnect.adapters.MyViewPagerAdapter
import com.example.handyconnect.model.IntroscreenModel
import kotlinx.android.synthetic.main.activity_intro.*

class IntroActivity : AppCompatActivity() {

    var adapter : MyViewPagerAdapter ?= null
    var list: ArrayList<IntroscreenModel> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)
        list.clear()

        list.add(IntroscreenModel("Title1",getString(R.string.dummy_content_two),R.drawable.loginbanner))
        list.add(IntroscreenModel("Title1",getString(R.string.dummy_content_two),R.drawable.loginbanner))
        list.add(IntroscreenModel("Title1",getString(R.string.dummy_content_two),R.drawable.loginbanner))

        setViewPagerAdapter()
        clicks()
    }
    private fun getItem(i: Int): Int {
        return viewPager.currentItem + i
    }
    private fun clicks() {
        butSkip.setOnClickListener {
            startActivity(Intent(this,SelectLanguageActivity::class.java))
        }
        butNext.setOnClickListener {
            val current: Int = getItem(+1)
            if (current < list.size) {
                // move to next screen
                viewPager.currentItem = current
            }
            else {
                startActivity(Intent(this,SelectLanguageActivity::class.java))
            }
        }
    }

    private fun setViewPagerAdapter() {
        adapter = MyViewPagerAdapter(list,this)
        viewPager.adapter = adapter
        dotIndicator.viewPager = viewPager
    }
}