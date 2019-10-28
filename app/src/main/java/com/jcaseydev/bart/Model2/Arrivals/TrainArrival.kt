package com.jcaseydev.bart.Model2.Arrivals

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

//@Entity(tableName = "train_data")
class TrainArrival {

    //@PrimaryKey(autoGenerate = true)
    var id: Int = 0

    @SerializedName("root")
    @Expose
    val root: ArrivalRoot? = null

    val arrivals: List<Etd>?
        get() = root!!.station!![0].etd

}