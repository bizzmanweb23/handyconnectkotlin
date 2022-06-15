package com.example.handyconnect.network.responses.simpleViewDescription

data class SimpleViewDeriptionResponse(
    val SuccessCode: Int,
    val `data`: List<Data>,
    val massage: String
)