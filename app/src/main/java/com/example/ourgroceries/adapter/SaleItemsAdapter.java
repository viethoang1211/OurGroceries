package com.example.ourgroceries.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ourgroceries.ItemDetails;
import com.example.ourgroceries.R;
import com.example.ourgroceries.model.SaleItems;

import java.util.List;

public class SaleItemsAdapter extends RecyclerView.Adapter<SaleItemsAdapter.SaleItemsViewHolder> {

    Context context;
    List<SaleItems> saleItemsList;

    public SaleItemsAdapter(Context context, List<SaleItems> saleItemsList) {
        this.context = context;
        this.saleItemsList = saleItemsList;
    }

    @NonNull
    @Override
    public SaleItemsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sale_items_items,parent,false);
        return new SaleItemsViewHolder(view);

        }

    @Override
    public void onBindViewHolder(@NonNull SaleItemsViewHolder holder, final int position) {
        holder.name.setText(saleItemsList.get(position).getName());
        holder.bg.setBackgroundResource(saleItemsList.get(position).getImageUrl());
        holder.quantity.setText(saleItemsList.get(position).getQuantity());
        holder.price.setText(new StringBuilder().append("$ ").append(saleItemsList.get(position).getPrice()).append(" /").toString());
        holder.unit.setText(saleItemsList.get(position).getUnit());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(context, ItemDetails.class);
                i.putExtra("name", saleItemsList.get(position).getName());
                i.putExtra("image", saleItemsList.get(position).getDetailedImageUrl());
                i.putExtra("price",saleItemsList.get(position).getPrice());
                i.putExtra("desc",saleItemsList.get(position).getDescription());
                i.putExtra("qty",saleItemsList.get(position).getQuantity());
                i.putExtra("unit",saleItemsList.get(position).getUnit());

                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return saleItemsList.size();
    }

    public static class SaleItemsViewHolder extends RecyclerView.ViewHolder{

        TextView name, price,quantity, unit;
        ConstraintLayout bg;
        public SaleItemsViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.saleItems_name);
            price= itemView.findViewById(R.id.saleItems_price);
            quantity= itemView.findViewById(R.id.saleItems_quantity);
            unit=itemView.findViewById(R.id.saleItems_unit);
            bg=itemView.findViewById(R.id.sale_layout);
        }
    }
}
