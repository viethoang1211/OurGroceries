package com.example.ourgroceries.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ourgroceries.CartView;
import com.example.ourgroceries.GlobalClass;
import com.example.ourgroceries.ItemDetails;
import com.example.ourgroceries.LoginActivity;
import com.example.ourgroceries.R;
import com.example.ourgroceries.model.SaleItems;

import java.util.ArrayList;
import java.util.List;

public class CartItemsAdapter extends RecyclerView.Adapter<CartItemsAdapter.CartItemsViewHolder> {

    Context context;
    List<SaleItems> saleItemsList;

    public CartItemsAdapter(Context context, List<SaleItems> saleItemsList) {
        this.context = context;
        this.saleItemsList = saleItemsList;
    }

    @NonNull
    @Override
    public CartItemsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cart_view_items,parent,false);
        return new CartItemsViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull CartItemsViewHolder holder, final int position) {
        holder.name.setText(saleItemsList.get(position).getName());
        holder.price.setText(new StringBuilder().append("$ ").append(saleItemsList.get(position).getPrice()).toString());
        holder.img.setImageResource(saleItemsList.get(position).getDetailedImageUrl());

        holder.remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<SaleItems> si= new ArrayList<>();
                si = ((GlobalClass)context.getApplicationContext()).getItemInCart();
                si.remove(position);
                ((GlobalClass)context.getApplicationContext()).setItemInCart(si);
                Toast.makeText(context,"Remove Successfully",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(context, CartView.class);
                context.startActivity(i);

            }
        });
    }

    @Override
    public int getItemCount() {
        return saleItemsList.size();
    }

    public static class CartItemsViewHolder extends RecyclerView.ViewHolder{

        TextView name, price;
        ImageView img, remove;
        public CartItemsViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.cart_item_name);
            price= itemView.findViewById(R.id.cart_item_price);
            img=itemView.findViewById(R.id.cart_item_image);
            remove = itemView.findViewById(R.id.cart_item_remove);
        }
    }
}
