package com.jcaseydev.bart.Model2.Fare

import android.net.Uri
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Root {

    @SerializedName("origin")
    @Expose
    var origin: String? = null
    @SerializedName("destination")
    @Expose
    var destination: String? = null
    @SerializedName("sched_num")
    @Expose
    var schedNum: String? = null
    @SerializedName("trip")
    @Expose
    var trip: Trip? = null
    @SerializedName("fares")
    @Expose
    var fares: Fares? = null
    @SerializedName("message")
    @Expose
    var message: String? = null

}
