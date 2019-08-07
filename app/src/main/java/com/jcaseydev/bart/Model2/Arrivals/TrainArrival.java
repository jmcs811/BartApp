package com.jcaseydev.bart.Model2.Arrivals;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Entity(tableName = "train_data")
public class TrainArrival {

  //@PrimaryKey(autoGenerate = true)
  private int id;

  @SerializedName("root")
  @Expose
  private ArrivalRoot root;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public ArrivalRoot getRoot() {
    return root;
  }

  public void setRoot(ArrivalRoot root) {
    this.root = root;
  }

}