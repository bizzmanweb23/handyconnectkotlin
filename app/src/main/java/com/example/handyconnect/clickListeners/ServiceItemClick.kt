package com.example.handyconnect.clickListeners

interface ServiceItemClick {
    fun onItemClick(position: Int, categoryId: String, id: String)
}