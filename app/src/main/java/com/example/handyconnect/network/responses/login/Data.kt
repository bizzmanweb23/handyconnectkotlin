package com.example.handyconnect.network.responses.login

data class Data(
    val credentials: Credentials,
    val status: Int,
    val token: String
)