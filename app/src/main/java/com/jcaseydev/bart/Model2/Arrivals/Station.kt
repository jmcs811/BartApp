package com.jcaseydev.bart.Model2.Arrivals

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Station {

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("abbr")
    @Expose
    var abbr: String? = null

    @SerializedName("etd")
    @Expose
    var etd: List<Etd>? = null

}
