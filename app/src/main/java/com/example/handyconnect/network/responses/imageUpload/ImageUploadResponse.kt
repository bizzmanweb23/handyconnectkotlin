package com.example.handyconnect.network.responses.imageUpload

data class ImageUploadResponse(
    val SuccessCode: Int,
    val `data`: ImageData,
    val message: String
)