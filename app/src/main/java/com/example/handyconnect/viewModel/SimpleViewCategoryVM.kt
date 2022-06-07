package com.example.handyconnect.viewModel

import android.content.Context
import androidx.databinding.BaseObservable
import androidx.lifecycle.MutableLiveData
import com.example.handyconnect.network.responses.simpleviewCategory.SimpleViewCategoryResponse
import com.example.handyconnect.utils.showProgress

class SimpleViewCategoryVM : BaseObservable() {

    var simpleViewCategory : MutableLiveData<SimpleViewCategoryResponse>?= null

    init {
        simpleViewCategory = MutableLiveData()
    }

    fun simpleViewCategoryMethod(context : Context){
        showProgress(context)

    }

}