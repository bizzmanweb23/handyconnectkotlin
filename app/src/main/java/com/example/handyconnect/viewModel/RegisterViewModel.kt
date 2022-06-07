package com.example.handyconnect.viewModel

import android.content.Context
import android.util.Log
import androidx.databinding.BaseObservable
import androidx.lifecycle.MutableLiveData
import com.example.handyconnect.network.ApiInterface
import com.example.handyconnect.network.WebServiceClient
import com.example.handyconnect.network.responses.login.LoginSuccessResponse
import com.example.handyconnect.network.responses.register.RegisterResponse
import com.example.handyconnect.utils.dismissProgress
import com.example.handyconnect.utils.showProgress
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterViewModel : BaseObservable() {

    var userRegister : MutableLiveData<RegisterResponse> ?= null
    var userLogin : MutableLiveData<LoginSuccessResponse> ?= null
    var failureResponse : MutableLiveData<String>? = null

    init {
        userRegister = MutableLiveData()
        userLogin = MutableLiveData()
        failureResponse = MutableLiveData()
    }

    fun userRegister(context : Context,name:String,email:String,mobile:String,
                     location:String,password:String,password_confirmation:String){
        showProgress(context)
        WebServiceClient(context).client.create(ApiInterface::class.java).RegisterApi(name,email,mobile,location,password,password_confirmation)
            .enqueue(object : Callback<RegisterResponse> {
                override fun onResponse(call: Call<RegisterResponse>,
                    response: Response<RegisterResponse>) {
                    dismissProgress()
                    Log.d("OnResponse",response.message())
                    userRegister?.value = response.body()
                }

                override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                    dismissProgress()
                    Log.d("OnFailure",t.localizedMessage)
                }

            })
    }

    fun userLogin(context : Context, email : String, password : String){
        showProgress(context)
        WebServiceClient(context).client.create(ApiInterface::class.java).LoginApi(email,password)
            .enqueue(object : Callback<LoginSuccessResponse>{
                override fun onResponse(
                    call: Call<LoginSuccessResponse>,
                    response: Response<LoginSuccessResponse>) {
                    dismissProgress()
                    Log.d("OnResponse",response.message())
                    userLogin?.value = response.body()
                }

                override fun onFailure(call: Call<LoginSuccessResponse>, t: Throwable) {
                    dismissProgress()
                    Log.d("OnFailure",t.localizedMessage)
                }

            })
    }

}