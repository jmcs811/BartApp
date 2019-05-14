package com.jcaseydev.bart.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Entity(tableName = "train_data")
public class TrainArrival {

    //@PrimaryKey(autoGenerate = true)
    private int id;

    @SerializedName("root")
    @Expose
    private Root root;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Root getRoot() {
        return root;
    }

    public void setRoot(Root root) {
        this.root = root;
    }

}