package com.example.matagaruda.Api;

public class UtilsApi {
    public static final String BASE_URL_API = "http://10.8.0.2:5000/";
    public static String username = "";
    public static String TOKEN = "";
    public static Api getAPIService(){
        return RetrofitClient.getClient(BASE_URL_API).create(Api.class);
    }

}