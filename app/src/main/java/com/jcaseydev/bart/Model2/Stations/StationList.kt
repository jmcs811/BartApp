package com.jcaseydev.bart.Model2.Stations

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class StationList {

    val id: Int = 0

    @SerializedName("root")
    @Expose
    val root: StationListRoot? = null

    val stations: List<Station>
        get() = root!!.stations?.station!!

}
