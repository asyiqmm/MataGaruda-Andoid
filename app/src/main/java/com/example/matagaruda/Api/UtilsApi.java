package com.example.matagaruda.Api;

public class UtilsApi {
    public static final String BASE_URL_API = "localhost:8000/";

    public static Api getAPIService(){
        return RetrofitClient.getClient(BASE_URL_API).create(Api.class);
    }
}
