package com.example.ourgroceries;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.ourgroceries.adapter.CategoryAdapter;
import com.example.ourgroceries.adapter.DiscountedProductAdapter;
import com.example.ourgroceries.adapter.SaleItemsAdapter;
import com.example.ourgroceries.model.Category;
import com.example.ourgroceries.model.DiscountedProducts;
import com.example.ourgroceries.model.SaleItems;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView discountRecyclerView, categoryRecyclerView, saleItemsRecycler;
    DiscountedProductAdapter discountedProductAdapter;
    List<DiscountedProducts> discountedProductsList;

    CategoryAdapter categoryAdapter;
    List<Category> categoryList;
    SaleItemsAdapter saleItemsAdapter;
    List<SaleItems> saleItemsList;

    ImageView allCategory,mainCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//<<<<<<< Updated upstream
//test change
//=======
        categoryRecyclerView = findViewById(R.id.categoryRecycler);
        discountRecyclerView = findViewById(R.id.discountedRecycler);
        allCategory = findViewById(R.id.allCategoryImage);
        saleItemsRecycler= findViewById(R.id.saleRecycler);
        mainCart=findViewById(R.id.mainCart);
//>>>>>>> Stashed changes


        allCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, AllCategory.class );
                startActivity(i);
            }
        });
        mainCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, CartView.class );
                startActivity(i);
            }
        });

        discountedProductsList= new ArrayList<>();
        discountedProductsList.add(new DiscountedProducts(1,R.drawable.discountberry));
        discountedProductsList.add(new DiscountedProducts(2,R.drawable.discountmeat));
        discountedProductsList.add(new DiscountedProducts(3,R.drawable.discountbrocoli));
        discountedProductsList.add(new DiscountedProducts(4,R.drawable.discountberry));
        discountedProductsList.add(new DiscountedProducts(5,R.drawable.discountmeat));
        discountedProductsList.add(new DiscountedProducts(6,R.drawable.discountbrocoli));
        setDiscountRecycler(discountedProductsList);


        categoryList= new ArrayList<>();
        categoryList.add(new Category(1,R.drawable.ic_home_fish));
        categoryList.add(new Category(2,R.drawable.ic_home_fruits));
        categoryList.add(new Category(3,R.drawable.ic_home_meats));
        categoryList.add(new Category(4,R.drawable.ic_home_veggies));
        categoryList.add(new Category(5,R.drawable.ic_home_meats));
        categoryList.add(new Category(6,R.drawable.ic_home_fruits));
        categoryList.add(new Category(7,R.drawable.ic_home_veggies));
        categoryList.add(new Category(8,R.drawable.ic_home_fish));

        setCategoryRecycler(categoryList);




        saleItemsList=new ArrayList<>();
        saleItemsList.add(new SaleItems("Watermelon", "Watermelon has high water content and also provides some fiber.", "3", "1", "KG",R.drawable.card4,R.drawable.b4));
        saleItemsList.add(new SaleItems("Strawberry", "The strawberry is a highly nutritious fruit, loaded with vitamin C.", "9", "1", "KG",R.drawable.card2,R.drawable.b1));
        saleItemsList.add(new SaleItems("Kiwi", "Full of nutrients like vitamin C, vitamin K, vitamin E, folate, and potassium.", "10", "1", "KG", R.drawable.card1,R.drawable.b2));
        saleItemsList.add(new SaleItems("Papaya", "Papayas are spherical or pear-shaped fruits that can be as long as 20 inches.", "5", "1", "KG",R.drawable.card3,R.drawable.b3));


        setSaleItemsRecycler(saleItemsList);
    }

    private void setDiscountRecycler(List<DiscountedProducts> dataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        discountRecyclerView.setLayoutManager(layoutManager);
        discountedProductAdapter = new DiscountedProductAdapter(this,dataList);
        discountRecyclerView.setAdapter(discountedProductAdapter);
    }
    private void setCategoryRecycler(List<Category> cateList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        categoryRecyclerView.setLayoutManager(layoutManager);
        categoryAdapter = new CategoryAdapter(this,cateList);
        categoryRecyclerView.setAdapter(categoryAdapter);
    }

    private void setSaleItemsRecycler(List<SaleItems> saleItemsList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        saleItemsRecycler.setLayoutManager(layoutManager);
        saleItemsAdapter = new SaleItemsAdapter(this,saleItemsList);
        saleItemsRecycler.setAdapter(saleItemsAdapter);
    }
}