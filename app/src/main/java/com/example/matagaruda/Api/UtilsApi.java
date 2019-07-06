package com.example.matagaruda.Api;

public class UtilsApi {
    public static final String BASE_URL_API = "http://202.46.4.52:5000/";
    public static String username = "";
    public static String password = "";
    public static Integer limit = 10;
    public static String company = "admin";
    public static String TOKEN = "";
    public static Api getAPIService(){
        return RetrofitClient.getClient(BASE_URL_API).create(Api.class);
    }

}