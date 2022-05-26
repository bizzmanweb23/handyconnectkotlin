package com.example.handyconnect

import android.app.DatePickerDialog
import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import java.text.SimpleDateFormat
import java.util.*

val myCalendar : Calendar = Calendar.getInstance()

fun changeStrokeColor(context : Context, view : View, color : Int){
    val drawable = view.background as GradientDrawable
    drawable.setStroke(1,ContextCompat.getColor(context,color))
}

fun openDatePicker(context: Context, tvCalender: TextView){
    var datePickerDialog = DatePickerDialog(context, { datePicker, year, month, day ->

        myCalendar.set(year,month,day)
        val myFormat = "dd - MMMM - yyyy"
        val dateFormat = SimpleDateFormat(myFormat, Locale.US)
        tvCalender.setText(dateFormat.format(myCalendar.time))

    }, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH))

    datePickerDialog.show()

}




