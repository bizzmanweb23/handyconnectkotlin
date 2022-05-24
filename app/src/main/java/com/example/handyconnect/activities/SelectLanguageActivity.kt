package com.example.handyconnect.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import com.example.handyconnect.R
import kotlinx.android.synthetic.main.activity_select_language.*

class SelectLanguageActivity : AppCompatActivity(), CompoundButton.OnCheckedChangeListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_language)

        clicks()
    }

    private fun clicks() {
        toggle_chinese.setOnCheckedChangeListener(this)
        toggle_english.setOnCheckedChangeListener(this)
    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        when(buttonView?.id){
            R.id.toggle_english -> {
                if(isChecked){
                    toggle_chinese.isChecked = false
                    startActivity(Intent(this,GetStartedActivity::class.java))
                }
            }
            R.id.toggle_chinese -> {
                if(isChecked){
                    toggle_english.isChecked = false
                    startActivity(Intent(this,GetStartedActivity::class.java))
                }
            }
        }
    }
}