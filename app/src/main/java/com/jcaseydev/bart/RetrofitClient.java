package com.jcaseydev.bart;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

//  private static Retrofit sRetrofit = null;
//
//  public static Retrofit getClient(String baseUrl) {
//    if (sRetrofit == null) {
//      sRetrofit = new Retrofit.Builder()
//          .baseUrl(baseUrl)
//          .addConverterFactory(GsonConverterFactory.create())
//          .build();
//    }
//    return sRetrofit;
//  }

  private static Retrofit retrofit;
  private static final String BASE_URL = "http://api.bart.gov/";

  public static Retrofit getClient() {
    if (retrofit == null) {
      retrofit = new Retrofit.Builder()
          .baseUrl(BASE_URL)
          .addConverterFactory(GsonConverterFactory.create())
          .build();
    }
    return retrofit;
  }
}
