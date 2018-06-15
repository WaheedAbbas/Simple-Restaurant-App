package com.mytrendin.googlemapsapp;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by ATTech_Android_1 on 29/04/2018.
 */

public class RestaurantsModal {
    public String logo;
    public String name, address;

    public RestaurantsModal(String name, String address, String logo) {
        this.name = name;
        this.address = address;
        this.logo = logo;
    }



}
