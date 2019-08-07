package com.jcaseydev.bart.Model2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StationList {

  private int id;

  @SerializedName("root")
  @Expose
  private Root root;

  public int getId() {return id;}

  public Root getRoot() {
    return root;
  }
}
