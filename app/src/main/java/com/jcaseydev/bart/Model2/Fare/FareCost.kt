package com.jcaseydev.bart.Model2.Fare

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class FareCost {

    @SerializedName("root")
    @Expose
    var root: Root? = null
        private set

    val origin: String
        get() = root!!.origin

    val destination: String
        get() = root!!.destination

    val fare: String
        get() = root!!.trip.fare

    fun setRoot() {
        this.root = root
    }

}
