package com.jcaseydev.bart;

import com.jcaseydev.bart.Model2.Arrivals.TrainArrival;

import com.jcaseydev.bart.Model2.Stations.StationList;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
  // public API key. DON'T BE ALARMED
  @GET("api/etd.aspx?cmd=etd&key=MW9S-E7SL-26DU-VV8V&orig=SFIA&json=y")
  Call<TrainArrival> getData();

  @GET("api/stn.aspx?cmd=stns&key=MW9S-E7SL-26DU-VV8V&json=y")
  Call<StationList> getStations();
}
