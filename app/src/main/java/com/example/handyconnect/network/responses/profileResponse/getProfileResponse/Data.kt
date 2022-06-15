package com.example.handyconnect.network.responses.profileResponse.getProfileResponse

data class Data(
    val created_at: String,
    val desciption: String,
    val email: String,
    val email_verified_at: String,
    val id: String,
    val location: String,
    val mobile: String,
    val name: String,
    val otp: String,
    val token: String,
    val updated_at: String,
    val user_type: String,
    val vendor_id: String
)