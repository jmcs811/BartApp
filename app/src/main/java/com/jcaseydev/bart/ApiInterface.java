package com.jcaseydev.bart;

import com.jcaseydev.bart.Model2.Arrivals.TrainArrival;
import com.jcaseydev.bart.Model2.Fare.FareCost;
import com.jcaseydev.bart.Model2.Fare.Root;
import com.jcaseydev.bart.Model2.Stations.StationList;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
  // public API key. DON'T BE ALARMED
  @GET("api/etd.aspx?cmd=etd&key=MW9S-E7SL-26DU-VV8V&json=y")
  Call<TrainArrival> getArrivals(@Query("orig") String station);

  @GET("api/stn.aspx?cmd=stns&key=MW9S-E7SL-26DU-VV8V&json=y")
  Call<StationList> getStations();

  @GET("api/sched.aspx?cmd=fare&key=MW9S-E7SL-26DU-VV8V&orig=12th&dest=embr&json=y")
  Call<FareCost> getFares();

  @GET("api/sched.aspx?cmd=fare&key=MW9S-E7SL-26DU-VV8V&orig=12th&dest=embr&json=y")
  Call<Root> getRoot();
}
