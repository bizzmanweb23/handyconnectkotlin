package com.example.handyconnect.network;


import com.example.handyconnect.network.responses.login.LoginSuccessResponse;
import com.example.handyconnect.network.responses.register.RegisterResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


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



}



























