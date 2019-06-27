package com.example.matagaruda.Api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface Api {
    @FormUrlEncoded
    @POST("api/token/v1.0/getauthtoken")
    Call<ResponseBody> userLogin(@Field("username") String username, @Field("password") String password, @Header("Authorization") String authtoken);
//
//    @FormUrlEncoded
//    @POST("api/token/v1.0/getauthtoken")
//    Call<ResponseBody> token(@Header("Authorization") String authtoken);


}
