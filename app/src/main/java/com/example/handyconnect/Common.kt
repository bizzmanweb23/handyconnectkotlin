package com.example.handyconnect

import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.view.View
import androidx.core.content.ContextCompat


fun changeStrokeColor(context : Context, view : View, color : Int){
    val drawable = view.background as GradientDrawable
    drawable.setStroke(1,ContextCompat.getColor(context,color))
}

