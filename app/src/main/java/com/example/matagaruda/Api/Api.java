package com.example.matagaruda.Api;

import com.example.matagaruda.Models.DefaultResponse;
import com.example.matagaruda.Models.LoginResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {
    
    @FormUrlEncoded
    @POST("createuser")
    Call<DefaultResponse> register(
            @Field("username") String username,
            @Field("password") String password,
            @Field("first_name") String first_name,
            @Field("last_name") String last_name,
            @Field("email") String email,
            @Field("company") String company
    );

    @FormUrlEncoded
    @POST("userlogin")
    Call<LoginResponse> userLogin(
            @Field("username") String username,
            @Field("password") String password
    );


}
