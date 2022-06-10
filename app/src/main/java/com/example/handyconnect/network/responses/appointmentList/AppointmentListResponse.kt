package com.example.handyconnect.network.responses.appointmentList

data class AppointmentListResponse(
    val Categorey: List<AppointmentSubList>,
    val SuccessCode: Int,
    val massage: String
)