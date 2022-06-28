package com.example.handyconnect.viewModel

import android.content.Context
import android.util.Log
import androidx.databinding.BaseObservable
import androidx.lifecycle.MutableLiveData
import com.example.handyconnect.network.ApiInterface
import com.example.handyconnect.network.WebServiceClient
import com.example.handyconnect.network.responses.appointmentListNew.AppointmentListResponseNew
import com.example.handyconnect.network.responses.pastappointment.PastAppointmentsResponse
import com.example.handyconnect.utils.dismissProgress
import com.example.handyconnect.utils.showProgress
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AppointmentListViewModel : BaseObservable() {

    var appointmentList: MutableLiveData<AppointmentListResponseNew>? = null
    var pastAppointmentList : MutableLiveData<PastAppointmentsResponse> ?= null

    init {
        appointmentList = MutableLiveData()
        pastAppointmentList = MutableLiveData()
    }

    fun appointmentListMethod(context : Context){
        showProgress(context)
        WebServiceClient(context).client.create(ApiInterface::class.java)
            .appointmentList().enqueue(object : Callback<AppointmentListResponseNew> {
                override fun onResponse(
                    call: Call<AppointmentListResponseNew>,
                    response: Response<AppointmentListResponseNew>) {

                    dismissProgress()
                    appointmentList?.value = response.body()
                    Log.d("OnResponse",response.message())

                }

                override fun onFailure(call: Call<AppointmentListResponseNew>, t: Throwable) {
                    dismissProgress()
                    Log.d("OnFailure",t.localizedMessage)
                }

            })
    }

    fun pastAppointmentListMethod(context : Context,user_id : String){
        showProgress(context)
        WebServiceClient(context).client.create(ApiInterface::class.java)
            .pastAppointmentsApi(user_id).enqueue(object : Callback<PastAppointmentsResponse>{
                override fun onResponse(
                    call: Call<PastAppointmentsResponse>, response: Response<PastAppointmentsResponse>) {
                    dismissProgress()
                    pastAppointmentList?.value = response.body()
                    Log.d("OnResponse",response.message())
                }

                override fun onFailure(call: Call<PastAppointmentsResponse>, t: Throwable) {
                    dismissProgress()
                    Log.d("OnFailure",t.localizedMessage)
                }

            })
    }
}