package com.example.handyconnect.viewModel

import android.content.Context
import android.util.Log
import androidx.databinding.BaseObservable
import androidx.lifecycle.MutableLiveData
import com.example.handyconnect.network.ApiInterface
import com.example.handyconnect.network.WebServiceClient
import com.example.handyconnect.network.responses.profileResponse.getProfileResponse.GetProfileResponse
import com.example.handyconnect.utils.dismissProgress
import com.example.handyconnect.utils.showProgress
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetProfileVM : BaseObservable() {
    var userGetProfile : MutableLiveData<GetProfileResponse> ?= null
    var userUpdateProfile : MutableLiveData<GetProfileResponse>  ?= null
    var failureResponse : MutableLiveData<String>? = null

    init {
        userGetProfile = MutableLiveData()
        userUpdateProfile = MutableLiveData()
        failureResponse = MutableLiveData()
    }

    fun getProfileMethod(context : Context,uid : String){
        showProgress(context)
        WebServiceClient(context).client.create(ApiInterface::class.java).getProfileApi(uid)
            .enqueue(object: Callback<GetProfileResponse>{
                override fun onResponse(
                    call: Call<GetProfileResponse>,
                    response: Response<GetProfileResponse>) {
                    dismissProgress()
                    userGetProfile?.value = response.body()
                    Log.d("OnResponse",response.message())
                }

                override fun onFailure(call: Call<GetProfileResponse>, t: Throwable) {
                    dismissProgress()
                    Log.d("OnFailure",t.localizedMessage)
                    failureResponse?.value ="Something went wrong"

                }

            })
    }

    fun updateProfileMethod(context : Context,uid : String,name:String,email:String,
                            mobile:String,location:String){
        showProgress(context)
        WebServiceClient(context).client.create(ApiInterface::class.java).
        profileUpdateApi(uid,name,email,mobile,location).enqueue(object : Callback<GetProfileResponse>{
            override fun onResponse(
                call: Call<GetProfileResponse>,
                response: Response<GetProfileResponse>
            ) {
                dismissProgress()
                userUpdateProfile?.value = response.body()
                Log.d("OnResponse",response.message())
            }

            override fun onFailure(call: Call<GetProfileResponse>, t: Throwable) {
                dismissProgress()
                Log.d("OnFailure",t.localizedMessage)
            }

        })

    }
}