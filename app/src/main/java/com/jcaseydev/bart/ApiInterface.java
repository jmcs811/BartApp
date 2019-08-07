package com.jcaseydev.bart;

import com.jcaseydev.bart.Model.TrainArrival;

import com.jcaseydev.bart.Model2.Station;
import com.jcaseydev.bart.Model2.StationList;
import com.jcaseydev.bart.Model2.Stations;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
  // public API key
  @GET("api/etd.aspx?cmd=etd&key=MW9S-E7SL-26DU-VV8V&orig=CONC&json=y")
  Call<TrainArrival> getData();

  @GET("api/stn.aspx?cmd=stns&key=MW9S-E7SL-26DU-VV8V&json=y")
  Call<StationList> getStations();
}
