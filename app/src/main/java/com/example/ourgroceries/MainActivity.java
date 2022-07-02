package com.example.ourgroceries;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.ourgroceries.adapter.CategoryAdapter;
import com.example.ourgroceries.adapter.DiscountedProductAdapter;
import com.example.ourgroceries.model.Category;
import com.example.ourgroceries.model.DiscountedProducts;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView discountRecyclerView, categoryRecyclerView;
    DiscountedProductAdapter discountedProductAdapter;
    List<DiscountedProducts> discountedProductsList;

    CategoryAdapter categoryAdapter;
    List<Category> categoryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//<<<<<<< Updated upstream
//test change
//=======
        categoryRecyclerView = findViewById(R.id.categoryRecycler);
        discountRecyclerView = findViewById(R.id.discountedRecycler);
//>>>>>>> Stashed changes

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
        categoryList.add(new Category(6,R.drawable.ic_home_fruits))
        setCategoryRecycler(categoryList);
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
}