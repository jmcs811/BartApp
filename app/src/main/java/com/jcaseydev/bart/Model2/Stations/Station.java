package com.jcaseydev.bart.Model2.Stations;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.Date;

@Entity
public class Station {

  @PrimaryKey
  private int id;

  @SerializedName("name")
  @Expose
  private String name;
  @SerializedName("abbr")
  @Expose
  private String abbr;
  @SerializedName("gtfs_latitude")
  @Expose
  private String gtfsLatitude;
  @SerializedName("gtfs_longitude")
  @Expose
  private String gtfsLongitude;
  @SerializedName("address")
  @Expose
  private String address;
  @SerializedName("city")
  @Expose
  private String city;
  @SerializedName("county")
  @Expose
  private String county;
  @SerializedName("state")
  @Expose
  private String state;
  @SerializedName("zipcode")
  @Expose
  private String zipcode;

  private Date lastRefresh;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAbbr() {
    return abbr;
  }

  public void setAbbr(String abbr) {
    this.abbr = abbr;
  }

  public String getGtfsLatitude() {
    return gtfsLatitude;
  }

  public void setGtfsLatitude(String gtfsLatitude) {
    this.gtfsLatitude = gtfsLatitude;
  }

  public String getGtfsLongitude() {
    return gtfsLongitude;
  }

  public void setGtfsLongitude(String gtfsLongitude) {
    this.gtfsLongitude = gtfsLongitude;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getCounty() {
    return county;
  }

  public void setCounty(String county) {
    this.county = county;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getZipcode() {
    return zipcode;
  }

  public void setZipcode(String zipcode) {
    this.zipcode = zipcode;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Date getLastRefresh() {
    return lastRefresh;
  }

  public void setLastRefresh(Date lastRefresh) {
    this.lastRefresh = lastRefresh;
  }

  @NonNull
  @Override
  public String toString() {
    return name;
  }
}
