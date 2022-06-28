package com.example.handyconnect.model

import com.example.handyconnect.network.responses.categoryServices.CategoryDetailData

class SelectedServiceModel (
    var isSelected : Boolean,
    val `data`: List<CategoryDetailData>)