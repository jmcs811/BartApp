package com.jcaseydev.bart.Model2.Fare

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Trip {

    @SerializedName("fare")
    @Expose
    var fare: String? = null
    @SerializedName("discount")
    @Expose
    var discount: Discount? = null

}
