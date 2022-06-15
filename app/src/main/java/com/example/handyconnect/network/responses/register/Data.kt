package com.example.handyconnect.network.responses.register

data class Data(
    val email: String,
    val id: String,
    val name: String,
    val token: String,
    val updated_at : String,
    val created_at : String

)