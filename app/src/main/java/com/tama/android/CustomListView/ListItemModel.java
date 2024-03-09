package com.tama.android.CustomListView;

import android.widget.ImageView;

public class ListItemModel {
    private String Type;
    private String title;

    public ListItemModel(String type, String title) {
        this.Type = type;
        this.title = title;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
