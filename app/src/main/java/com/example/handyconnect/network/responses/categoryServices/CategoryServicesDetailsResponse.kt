package com.example.handyconnect.network.responses.categoryServices

data class CategoryServicesDetailsResponse(
    val SuccessCode: Int,
    val `data`: List<CategoryDetailData>,
    val massage: String
)