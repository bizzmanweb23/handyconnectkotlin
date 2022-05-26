package com.example.handyconnect.activities.optimizedView

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.handyconnect.R
import com.example.handyconnect.activities.MainActivity
import com.example.handyconnect.activities.NotificationActivity
import com.example.handyconnect.activities.optimizedView.fragments.*
import com.google.android.material.navigation.NavigationBarView
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.nav_main_layout.view.*
import nl.psdcompany.duonavigationdrawer.views.DuoDrawerLayout
import nl.psdcompany.duonavigationdrawer.widgets.DuoDrawerToggle

class HomeActivity : AppCompatActivity() {

    private var mDuoDrawerLayout : DuoDrawerLayout ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_home)

        mDuoDrawerLayout = DuoDrawerLayout(this)

        handleDrawer()
        clicks()
        inflateFragments()

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, HomeFragment())
            .commit()

    }

    private fun inflateFragments() {
        bottom_navigation.setOnItemSelectedListener(object : NavigationBarView.OnItemSelectedListener{
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when(item.itemId){
                    R.id.home ->{
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.container, HomeFragment())
                            .commit()
                    }
                    R.id.aboutUs ->{
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.container, AboutUsFragment())
                            .commit()
                    }
                    R.id.appointment ->{
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.container, AppointmentFragment())
                            .commit()
                    }
                    R.id.quotation ->{
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.container, QuotationFragment())
                            .commit()
                    }
                    R.id.profile -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.container, ProfileFragment())
                            .commit()
                    }
                }
                return true
            }
        })
    }

    private fun clicks() {
        butMenu.setOnClickListener {
            if(drawer.isDrawerOpen){
                drawer.closeDrawer()
            }
            else{
                drawer.openDrawer()
            }
        }

        drawer.imgCross.setOnClickListener {
            drawer.closeDrawer()
        }

        drawer.sec_engageNow.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }

        drawer.sec_profile.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, ProfileFragment())
                .commit()
            drawer.closeDrawer()
        }

        drawer.sec_newsFeed.setOnClickListener {
            startActivity(Intent(this,FeedActivity::class.java))
        }

        drawer.sec_notification.setOnClickListener {
            startActivity(Intent(this, NotificationActivity::class.java))
        }

        drawer.sec_referalSystem.setOnClickListener {
            startActivity(Intent(this,ReferalSystemActivity::class.java))
        }

        drawer.sec_payment.setOnClickListener {
            startActivity(Intent(this,PaymentActivity::class.java))
        }

        drawer.sec_liveChat.setOnClickListener {
           startActivity(Intent(this,LiveChatActivity::class.java))
        }

        drawer.sec_transaction.setOnClickListener {
            startActivity(Intent(this,TransactionActivity::class.java))
        }

    }

    private fun handleDrawer() {
        val duoDrawerToggle = DuoDrawerToggle(this,
            mDuoDrawerLayout, null,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close)

        mDuoDrawerLayout!!.setDrawerListener(duoDrawerToggle)
        duoDrawerToggle.syncState()

    }
}