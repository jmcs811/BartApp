package com.jcaseydev.bart.Model;


import android.util.Xml;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example {

    @SerializedName("?xml")
    @Expose
    private Xml xml;
    @SerializedName("root")
    @Expose
    private TrainArrival root;

    public Xml getXml() {
        return xml;
    }

    public void setXml(Xml xml) {
        this.xml = xml;
    }

    public TrainArrival getRoot() {
        return root;
    }

    public void setRoot(TrainArrival root) {
        this.root = root;
    }

}