package com.jcaseydev.bart;

import com.jcaseydev.bart.Model.Root;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("etd.aspx?cmd=etd&key=API_KEY&orig=ANTC&json=y")
    Call<Root> getData();
}
