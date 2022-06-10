package com.example.handyconnect.network.responses.appointmentListNew

data class AppointmentListResponseNew(
    val SuccessCode: Int,
    val `data`: List<AppointmentSubListNew>,
    val massage: String
)