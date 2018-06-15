package com.mytrendin.googlemapsapp;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by ATTech_Android_1 on 01/05/2018.
 */

public class TableModal
{

    public String tableId, status;
    boolean selected;


    public TableModal(String tableId, String status) {

        this.tableId = tableId;
        this.status = status;
    }

    public boolean isSelected(){return selected;}
    public void setSelected(boolean selected){this.selected=selected;}
}
