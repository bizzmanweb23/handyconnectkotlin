package com.example.handyconnect.activities.optimizedView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.handyconnect.R
import com.example.handyconnect.activities.optimizedView.fragments.PointFragment
import com.example.handyconnect.activities.optimizedView.fragments.ReferFragment
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_referal_system.*

class ReferalSystemActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_referal_system)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragContainer,ReferFragment())
            .commit()

        setTabLayoutClicks()
        clicks()

    }

    private fun clicks() {
        butBack.setOnClickListener {
            tabs_layout.getTabAt(0)?.select()
            butBack.visibility = View.GONE
            crossImage.visibility = View.VISIBLE
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragContainer,ReferFragment())
                .commit()
        }
        crossImage.setOnClickListener {
            onBackPressed()
        }
    }

    private fun setTabLayoutClicks() {
        tabs_layout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when(tab?.position){
                    0 ->{
                        butBack.visibility = View.GONE
                        crossImage.visibility = View.VISIBLE
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.fragContainer,ReferFragment())
                            .commit()
                    }
                    1 ->{
                        butBack.visibility = View.VISIBLE
                        crossImage.visibility = View.GONE
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.fragContainer,PointFragment())
                            .commit()
                    }
                }
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }
            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })
    }

}