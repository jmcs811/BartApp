package com.jcaseydev.bart.Model2.Stations;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StationList {

  private int id;

  @SerializedName("root")
  @Expose
  private StationListRoot root;

  public int getId() {return id;}

  public StationListRoot getRoot() {
    return root;
  }
}
