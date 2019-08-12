package com.jcaseydev.bart.Model2.Fare;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FareCost {

  @SerializedName("root")
  @Expose
  private Root root;

  public Root getRoot() {
    return root;
  }

  public void setRoot() {
    this.root = root;
  }

  public String getOrigin() {
    return getRoot().getOrigin();
  }

  public String getDestination() {
    return getRoot().getDestination();
  }

  public String getFare() {
    return getRoot().getTrip().getFare();
  }

}
