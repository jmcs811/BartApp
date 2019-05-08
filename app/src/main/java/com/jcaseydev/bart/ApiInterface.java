package com.jcaseydev.bart;

import com.jcaseydev.bart.Model.Example;
import com.jcaseydev.bart.Model.TrainArrival;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    // public API key
    @GET("api/etd.aspx?cmd=etd&key=MW9S-E7SL-26DU-VV8V&orig=ANTC&json=y")
    Call<Example> getData();
}
