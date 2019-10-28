package com.jcaseydev.bart.Model2.Fare

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Fare {

    @SerializedName("@amount")
    @Expose
    var amount: String? = null
    @SerializedName("@class")
    @Expose
    var class_: String? = null
    @SerializedName("@name")
    @Expose
    var name: String? = null

}
