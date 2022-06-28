package com.example.handyconnect.network.responses.pastappointment

data class Response(
    val CategoryName: String,
    val address: String,
    val date: String,
    val email: String,
    val mobile: String,
    val name: String,
    val service_id: String,
    val services: List<Service>,
    val state: String,
    val time: String,
    val zip_code: String
)