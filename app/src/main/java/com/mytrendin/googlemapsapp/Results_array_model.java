package com.mytrendin.googlemapsapp;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ATTech_Android_1 on 30/04/2018.
 */

public class Results_array_model {
    @SerializedName("geometry")
    public Geometry_model geometry;

    @SerializedName("icon")
    public String icon;
    @SerializedName("name")
    public String name;
    @SerializedName("rating")
    public String rating;

    @SerializedName("reference")
    public String reference;
    @SerializedName("vicinity")
    public String vicinity;
}
