package com.example.matagaruda.Api;

import com.example.matagaruda.Models.EventsModel;
import com.example.matagaruda.Models.EventsRaw;
import com.example.matagaruda.Models.SensorModel;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

public interface Api {
    @FormUrlEncoded //login user
    @POST("api/token/v1.0/getauthtoken")
    Call<ResponseBody> loginUser(
            @Field("username") String username,
            @Field("password") String password,
            @Header("Authorization") String authtoken);

    @FormUrlEncoded //register user
    @POST("api/users/v1.0/createuser")
    Call<ResponseBody> createUser(
            @Field("username") String username,
            @Field("first_name") String first_name,
            @Field("last_name") String last_name,
            @Field("password_hash") String password_hash,
            @Field("email") String email,
            @Field("company") String company);

    @FormUrlEncoded // List Sensor
    @POST("/api/sensors/v1.0/listsensors")
    Call<SensorModel> listSensor(
            @Field("username") String username,
            @Field("password") String password,
            @Header("Authorization") String authtoken);


    @POST("/api/statistic/v1.0/rawdata")
    Call<EventsModel> listEvents(
            @Header("Authorization") String authtoken,
            @Body EventsRaw raw);


}
