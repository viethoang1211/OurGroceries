package com.example.ourgroceries.model;

import android.view.View;

public class DiscountedProducts {

    Integer id;
    int imageurl;

    public DiscountedProducts(Integer id, int imageurl) {
        this.id = id;
        this.imageurl = imageurl;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getImageurl() {
        return imageurl;
    }

    public void setImageurl(int imageurl) {
        this.imageurl = imageurl;
    }
}
