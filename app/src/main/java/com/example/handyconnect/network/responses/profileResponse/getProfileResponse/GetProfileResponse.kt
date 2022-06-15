package com.example.handyconnect.network.responses.profileResponse.getProfileResponse

data class GetProfileResponse(
    val SuccessCode: Int,
    val `data`: Data,
    val message: String
)