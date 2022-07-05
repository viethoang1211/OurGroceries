package com.example.ourgroceries;

import android.app.LauncherActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ourgroceries.adapter.CartItemsAdapter;
import com.example.ourgroceries.adapter.CategoryAdapter;
import com.example.ourgroceries.model.SaleItems;

import java.util.ArrayList;
import java.util.List;

public class CartView extends AppCompatActivity {
    RecyclerView cartRecyclerView;
    CartItemsAdapter cartItemsAdapter;
    ImageView back;
    List<SaleItems> cartItems;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_view);

        back=findViewById(R.id.back3);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CartView.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        cartRecyclerView =  findViewById(R.id.cartRecycler);

        cartItems=new ArrayList<>();
        cartItems = ((GlobalClass)this.getApplication()).getItemInCart();


        setCartRecycler(cartItems);
    }

    private void setCartRecycler(List<SaleItems> cartItems) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        cartRecyclerView.setLayoutManager(layoutManager);
        cartItemsAdapter = new CartItemsAdapter(this,cartItems);
        cartRecyclerView.setAdapter(cartItemsAdapter);
    }

}

