package com.example.handyconnect.network.responses.register

data class Data(
    val email: String,
    val id: Int,
    val name: String,
    val token: String
)