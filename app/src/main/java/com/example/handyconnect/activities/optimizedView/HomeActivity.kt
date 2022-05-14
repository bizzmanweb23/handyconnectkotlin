package com.example.handyconnect.activities.optimizedView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.handyconnect.R
import com.example.handyconnect.activities.optimizedView.fragments.AboutUsFragment
import com.example.handyconnect.activities.optimizedView.fragments.AppointmentFragment
import com.example.handyconnect.activities.optimizedView.fragments.HomeFragment
import com.google.android.material.navigation.NavigationBarView
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.nav_main_layout.view.*
import nl.psdcompany.duonavigationdrawer.views.DuoDrawerLayout
import nl.psdcompany.duonavigationdrawer.widgets.DuoDrawerToggle

class HomeActivity : AppCompatActivity() {
    private var mDuoDrawerLayout : DuoDrawerLayout?= null

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

                    }
                    R.id.profile -> {

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
    }

    private fun handleDrawer() {
        val duoDrawerToggle = DuoDrawerToggle(
            this,
            mDuoDrawerLayout, null,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )

        mDuoDrawerLayout!!.setDrawerListener(duoDrawerToggle)
        duoDrawerToggle.syncState()
    }
}