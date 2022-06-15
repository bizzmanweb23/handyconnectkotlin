package com.example.handyconnect.network.responses.categoryServices

data class CategoryDetailData(
    val category_id: String,
    val created_at: String,
    val id: String,
    val price: String,
    val service_image: String,
    val service_name: String,
    val service_unique_id: String,
    val tax: String,
    val unit_of_measure_id: String,
    val updated_at: String
)