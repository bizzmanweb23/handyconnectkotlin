package com.example.handyconnect.viewModel

import android.content.Context
import android.util.Log
import androidx.databinding.BaseObservable
import androidx.lifecycle.MutableLiveData
import com.example.handyconnect.network.ApiInterface
import com.example.handyconnect.network.WebServiceClient
import com.example.handyconnect.network.responses.categoryServices.CategoryServicesDetailsResponse
import com.example.handyconnect.network.responses.imageUpload.ImageUploadResponse
import com.example.handyconnect.network.responses.simpleViewDescription.SimpleViewDeriptionResponse
import com.example.handyconnect.network.responses.simpleviewCategory.SimpleViewCategoryResponse
import com.example.handyconnect.utils.dismissProgress
import com.example.handyconnect.utils.showProgress
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SimpleViewCategoryVM : BaseObservable() {

    var simpleViewCategory : MutableLiveData<SimpleViewCategoryResponse>?= null
    var simpleViewCategoryDetails : MutableLiveData<CategoryServicesDetailsResponse>?= null
    var uploadImage : MutableLiveData<ImageUploadResponse> ?= null
    var selectedService : MutableLiveData<SimpleViewDeriptionResponse> ?= null

    init {
        simpleViewCategory = MutableLiveData()
        simpleViewCategoryDetails = MutableLiveData()
        uploadImage = MutableLiveData()
        selectedService = MutableLiveData()
    }

    fun simpleViewCategoryMethod(context : Context){
        showProgress(context)
        WebServiceClient(context).client.create(ApiInterface::class.java).simpleViewCategoryApi()
            .enqueue(object : Callback<SimpleViewCategoryResponse>{
                override fun onResponse(
                    call: Call<SimpleViewCategoryResponse>,
                    response: Response<SimpleViewCategoryResponse>
                ) {
                    dismissProgress()
                    Log.d("OnResponse",response.message())
                    simpleViewCategory?.value = response.body()
                }

                override fun onFailure(call: Call<SimpleViewCategoryResponse>, t: Throwable) {
                    dismissProgress()
                    Log.d("OnFailure",t.localizedMessage)
                }

            })

    }

    fun simpleViewCategoryDetails(context : Context,CategoryID : String){
        showProgress(context)
        WebServiceClient(context).client.create(ApiInterface::class.java)
            .simpleViewCateDetailApi(CategoryID).enqueue(object : Callback<CategoryServicesDetailsResponse>{
                override fun onResponse(
                    call: Call<CategoryServicesDetailsResponse>,
                    response: Response<CategoryServicesDetailsResponse>) {
                    dismissProgress()
                    Log.d("OnResponse",response.message())
                    simpleViewCategoryDetails?.value = response.body()
                }

                override fun onFailure(call: Call<CategoryServicesDetailsResponse>, t: Throwable) {
                    dismissProgress()
                    Log.d("OnFailure",t.localizedMessage)
                }

            })
    }

    fun uploadImageMethod(context : Context,remark_upload : MultipartBody.Part,uid : String){
        showProgress(context)
        WebServiceClient(context).client.create(ApiInterface::class.java)
            .imageUploadApi(remark_upload,uid).enqueue(object : Callback<ImageUploadResponse>{
                override fun onResponse(
                    call: Call<ImageUploadResponse>,
                    response: Response<ImageUploadResponse>) {
                    dismissProgress()
                    Log.d("OnResponse",response.message())
                    uploadImage?.value = response.body()
                }

                override fun onFailure(call: Call<ImageUploadResponse>, t: Throwable) {
                    dismissProgress()
                    Log.d("OnFailure",t.localizedMessage)
                }

            })

    }

    fun simpleServiceDescriptionMethod(context : Context,user_id : String,categorey_id:String,
                                       service_id:String,description:String){
        showProgress(context)
        WebServiceClient(context).client.create(ApiInterface::class.java).simpleViewDes(user_id,categorey_id,
        service_id,description).enqueue(object : Callback<SimpleViewDeriptionResponse>{
            override fun onResponse(
                call: Call<SimpleViewDeriptionResponse>,
                response: Response<SimpleViewDeriptionResponse>
            ) {
                dismissProgress()
                Log.d("OnResponse",response.message())
                selectedService?.value = response.body()
            }

            override fun onFailure(call: Call<SimpleViewDeriptionResponse>, t: Throwable) {
                dismissProgress()
                Log.d("OnFailure",t.localizedMessage)
            }

        })
    }

}