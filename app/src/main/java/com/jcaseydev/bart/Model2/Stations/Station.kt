package com.jcaseydev.bart.Model2.Stations

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.Date

@Entity
class Station {

    @PrimaryKey
    var id: Int = 0

    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("abbr")
    @Expose
    var abbr: String? = null
    @SerializedName("gtfs_latitude")
    @Expose
    var gtfsLatitude: String? = null
    @SerializedName("gtfs_longitude")
    @Expose
    var gtfsLongitude: String? = null
    @SerializedName("address")
    @Expose
    var address: String? = null
    @SerializedName("city")
    @Expose
    var city: String? = null
    @SerializedName("county")
    @Expose
    var county: String? = null
    @SerializedName("state")
    @Expose
    var state: String? = null
    @SerializedName("zipcode")
    @Expose
    var zipcode: String? = null

    var lastRefresh: Date? = null
}
