package com.tama.android.CustomListView;

import android.media.Image;

public class DataModel {
    private int icon;
    private String text;


    public DataModel(String text) {
        this.text = text;
//        if text <=3 then set icon = star image from android resource
//        else set icon = earth image from android resource

        if (text.length() <= 3) {
            this.icon = android.R.drawable.star_big_on;
        } else {
            this.icon = android.R.drawable.ic_dialog_map;
        }
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


}
