package com.jcaseydev.bart.Model2.Stations;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StationListRoot {

  @SerializedName("stations")
  @Expose
  private Stations stations;
  @SerializedName("message")
  @Expose
  private String message;

  public Stations getStations() {
    return stations;
  }

  public void setStations(Stations stations) {
    this.stations = stations;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

}