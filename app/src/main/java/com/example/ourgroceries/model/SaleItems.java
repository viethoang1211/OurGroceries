package com.example.ourgroceries.model;

import android.graphics.drawable.Drawable;

public class SaleItems {

    String name;
    String description;
    String price;
    String quantity;
    String unit;
    int imageUrl;
    int detailedImageUrl;


    public int getDetailedImageUrl() {
        return detailedImageUrl;
    }

    public void setDetailedImageUrl(int detailedImageUrl) {
        this.detailedImageUrl = detailedImageUrl;
    }

    public SaleItems(String name, String description, String price, String quantity, String unit, int imageUrl, int detailedImageUrl) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.unit = unit;
        this.imageUrl = imageUrl;
        this.detailedImageUrl = detailedImageUrl;
    }


    public SaleItems(String name, Integer imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
    }

    public SaleItems(String name, String description, String price, String quantity, String unit, Integer detailedImageUrl) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.unit = unit;
        this.detailedImageUrl = detailedImageUrl;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }
}
