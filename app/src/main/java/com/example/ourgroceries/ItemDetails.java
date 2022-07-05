package com.example.ourgroceries;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ourgroceries.model.SaleItems;

import java.util.ArrayList;
import java.util.List;

public class ItemDetails extends AppCompatActivity {
    String name,desc,price,quantity,unit;
    int image;
    TextView iName, iPrice, iDesc,addToCart;
    ImageView iImage, back;
    List<SaleItems> allCartItems;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);

        Intent i = getIntent();
        name = i.getStringExtra("name");
        image= i.getIntExtra("image",R.drawable.b1);
        desc= i.getStringExtra("desc");
        quantity= i.getStringExtra("qty");
        price= i.getStringExtra("price");
        unit=i.getStringExtra("unit");

        back=findViewById(R.id.back1);
        addToCart=findViewById(R.id.addToCart);

        iName= findViewById(R.id.itemName);
        iImage=findViewById(R.id.itemImage);
        iPrice=findViewById(R.id.itemPrice);
        iDesc=findViewById(R.id.itemDesc);

        iName.setText(name);
        iDesc.setText(desc);
        String hmm= "$" +price +"/ "+ quantity+" "+unit;
        iPrice.setText(hmm);
        iImage.setImageResource(image);


        allCartItems= new ArrayList<>();
        allCartItems = ((GlobalClass)this.getApplication()).getItemInCart();

        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                allCartItems.add(new SaleItems(name,desc,price,quantity,unit,image));
                ((GlobalClass)ItemDetails.this.getApplication()).setItemInCart(allCartItems);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ItemDetails.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}
