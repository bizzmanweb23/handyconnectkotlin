package com.example.handyconnect.network;


import com.example.handyconnect.network.responses.appointmentList.AppointmentListResponse;
import com.example.handyconnect.network.responses.appointmentListNew.AppointmentListResponseNew;
import com.example.handyconnect.network.responses.categoryServices.CategoryServicesDetailsResponse;
import com.example.handyconnect.network.responses.imageUpload.ImageUploadResponse;
import com.example.handyconnect.network.responses.login.LoginSuccessResponse;
import com.example.handyconnect.network.responses.profileResponse.getProfileResponse.GetProfileResponse;
import com.example.handyconnect.network.responses.register.RegisterResponse;
import com.example.handyconnect.network.responses.simpleViewDescription.SimpleViewDeriptionResponse;
import com.example.handyconnect.network.responses.simpleviewCategory.SimpleViewCategoryResponse;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;


public interface ApiInterface {

    @FormUrlEncoded
    @POST("simpleview/register")
    Call<RegisterResponse> RegisterApi(
            @Field("name") String name,
            @Field("email") String email,
            @Field("mobile") String mobile,
            @Field("location") String location,
            @Field("password") String password,
            @Field("password_confirmation") String password_confirmation);

    @FormUrlEncoded
    @POST("simpleview/login")
    Call<LoginSuccessResponse> LoginApi(
            @Field("email") String email,
            @Field("password") String password);


    @GET("simpleview/category")
    Call<SimpleViewCategoryResponse> simpleViewCategoryApi();


    @GET("simpleview/services/get?")
    Call<CategoryServicesDetailsResponse> simpleViewCateDetailApi(@Query("cat_id") String cat_id);

    @GET("optimize/get/appointments")
    Call<AppointmentListResponseNew> appointmentList();

    @Multipart
    @POST("simpleview/remark/upload/image/")
    Call<ImageUploadResponse> imageUploadApi(
            @Part MultipartBody.Part remark_upload,
            @Part("uid") String uid);

    @FormUrlEncoded
    @POST("simpleview/description/")
    Call<SimpleViewDeriptionResponse> simpleViewDes(
            @Field("user_id") String user_id,
            @Field("categorey_id") String categorey_id,
            @Field("service_id") String service_id,
            @Field("description") String description
    );

    @GET("optimize/profile/management")
    Call<GetProfileResponse> getProfileApi(
            @Query("uid") String uid
    );

    @FormUrlEncoded
    @POST("optimize/profile/update")
    Call<GetProfileResponse> profileUpdateApi(
            @Field("uid") String uid,
            @Field("name") String name,
            @Field("email") String email,
            @Field("mobile") String mobile,
            @Field("location") String location
    );



}



























