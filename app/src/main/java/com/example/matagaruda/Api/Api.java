package com.example.matagaruda.Api;

import com.example.matagaruda.Models.*;
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

    @POST("api/users/v1.0/createuser") //register
    Call<User> createUser(@Body User user);

    @FormUrlEncoded // List Sensor
    @POST("/api/sensors/v1.0/listsensors")
    Call<SensorModel> listSensor(
            @Field("username") String username,
            @Field("password") String password,
            @Header("Authorization") String authtoken);

    @POST("/api/statistic/v1.0/rawdata") //events
    Call<EventsModel> listEvents(
            @Header("Authorization") String authtoken,
            @Body EventsRaw raw);

    @POST("/api/sensors/v1.0/createsensor") //create sensor
    Call<SensorRaw> createSensor(
            @Header("Authorization") String authtoken,
            @Body SensorRaw sensorRaw);

}
