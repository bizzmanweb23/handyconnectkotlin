package com.example.handyconnect.network.responses.pastappointment

data class PastAppointmentsResponse(
    val massage: String,
    val response: List<Response>,
    val success: Int
)