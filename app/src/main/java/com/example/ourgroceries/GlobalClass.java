package com.example.ourgroceries;

import android.app.Application;

import com.example.ourgroceries.model.SaleItems;

import java.util.ArrayList;
import java.util.List;

public class GlobalClass extends Application {
    private List<SaleItems> itemInCart =new ArrayList<>();

    public List<SaleItems> getItemInCart() {
        return itemInCart;
    }

    public void setItemInCart(List<SaleItems> itemInCart) {
        this.itemInCart = itemInCart;
    }

}
