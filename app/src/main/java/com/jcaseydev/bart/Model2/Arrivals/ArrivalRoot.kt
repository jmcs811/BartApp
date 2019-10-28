package com.jcaseydev.bart.Model2.Arrivals

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ArrivalRoot {

    @SerializedName("@id")
    @Expose
    var id: String? = null

    @SerializedName("date")
    @Expose
    var date: String? = null

    @SerializedName("time")
    @Expose
    var time: String? = null

    @SerializedName("station")
    @Expose
    var station: List<Station>? = null

    @SerializedName("message")
    @Expose
    var message: String? = null

}