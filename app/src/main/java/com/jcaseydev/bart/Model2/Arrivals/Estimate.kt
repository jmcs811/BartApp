package com.jcaseydev.bart.Model2.Arrivals

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Estimate {

    @SerializedName("minutes")
    @Expose
    var minutes: String? = null

    @SerializedName("platform")
    @Expose
    var platform: String? = null

    @SerializedName("direction")
    @Expose
    var direction: String? = null

    @SerializedName("length")
    @Expose
    var length: String? = null

    @SerializedName("color")
    @Expose
    var color: String? = null

    @SerializedName("hexcolor")
    @Expose
    var hexcolor: String? = null

    @SerializedName("bikeflag")
    @Expose
    var bikeflag: String? = null

    @SerializedName("delay")
    @Expose
    var delay: String? = null

}
