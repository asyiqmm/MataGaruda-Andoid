package com.example.matagaruda.Api;

public class UtilsApi {
    public static final String BASE_URL_API = "http://10.8.0.2:5000/";
    public static String username = "";
    public static String password = "";
    public static Integer limit = 10;
    public static String company = "admin";
    public static String TOKEN = "";
    String api = "202.46.4.52";
    public static Api getAPIService(){
        return RetrofitClient.getClient(BASE_URL_API).create(Api.class);
    }

}