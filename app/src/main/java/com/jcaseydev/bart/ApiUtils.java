package com.jcaseydev.bart;

import retrofit2.Retrofit;

public class ApiUtils {

  public static final String BASE_URL = "http://api.bart.gov/";

  public static ApiInterface getApiInterface() {
    return RetrofitClient.getClient(BASE_URL).create(ApiInterface.class);
  }
}
