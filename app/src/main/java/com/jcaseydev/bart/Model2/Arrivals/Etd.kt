package com.jcaseydev.bart.Model2.Arrivals

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Etd {

    @SerializedName("destination")
    @Expose
    var destination: String? = null

    @SerializedName("abbreviation")
    @Expose
    var abbreviation: String? = null

    @SerializedName("limited")
    @Expose
    var limited: String? = null

    @SerializedName("estimate")
    @Expose
    var estimate: List<Estimate>? = null

}
