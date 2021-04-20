package com.mobile.azrinurvani.e_commercesimpleexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.mobile.azrinurvani.e_commercesimpleexample.adapter.CategoryAdapter;
import com.mobile.azrinurvani.e_commercesimpleexample.adapter.DiscountProductAdapter;
import com.mobile.azrinurvani.e_commercesimpleexample.adapter.RecentlyViewedAdapter;
import com.mobile.azrinurvani.e_commercesimpleexample.model.Category;
import com.mobile.azrinurvani.e_commercesimpleexample.model.DiscountedProducts;
import com.mobile.azrinurvani.e_commercesimpleexample.model.RecentlyViewed;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView discountRecyclerView,categoryRecyclerView,recentlyRecycler;
    DiscountProductAdapter discountProductAdapter;
    List<DiscountedProducts> discountedProductsList;

    List<Category> categoryList;
    CategoryAdapter categoryAdapter;

    List<RecentlyViewed> recentlyViewedList;
    RecentlyViewedAdapter recentlyViewedAdapter;

    ImageView allCategoryImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        discountRecyclerView = findViewById(R.id.discountedRecycler);
        categoryRecyclerView = findViewById(R.id.categoryRecycler);
        allCategoryImage = findViewById(R.id.allCategoryImage);
        recentlyRecycler = findViewById(R.id.recentlyRecyclerView);


        discountedProductsList = new ArrayList<>();
        discountedProductsList.add(new DiscountedProducts(1,R.drawable.discountberry));
        discountedProductsList.add(new DiscountedProducts(2,R.drawable.discountbrocoli));
        discountedProductsList.add(new DiscountedProducts(3,R.drawable.discountmeat));
        discountedProductsList.add(new DiscountedProducts(4,R.drawable.discountberry));
        discountedProductsList.add(new DiscountedProducts(5,R.drawable.discountbrocoli));
        discountedProductsList.add(new DiscountedProducts(6,R.drawable.discountmeat));
        setDiscountRecycler(discountedProductsList);

        categoryList = new ArrayList<>();
        categoryList.add(new Category(1,R.drawable.ic_home_fish));
        categoryList.add(new Category(2,R.drawable.ic_home_fruits));
        categoryList.add(new Category(3,R.drawable.ic_home_meats));
        categoryList.add(new Category(4,R.drawable.ic_home_veggies));
        categoryList.add(new Category(5,R.drawable.ic_home_fish));
        categoryList.add(new Category(6,R.drawable.ic_home_fruits));
        categoryList.add(new Category(7,R.drawable.ic_home_meats));
        categoryList.add(new Category(8,R.drawable.ic_home_veggies));

        setCategoryRecycler(categoryList);

        allCategoryImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AllCategoryActivity.class);
                startActivity(intent);
            }
        });

        recentlyViewedList = new ArrayList<>();
        recentlyViewedList = new ArrayList<>();
        recentlyViewedList.add(new RecentlyViewed("Watermelon", "Watermelon has high water content and also provides some fiber.", "₹ 80", "1", "KG", R.drawable.card4, R.drawable.b4));
        recentlyViewedList.add(new RecentlyViewed("Papaya", "Papayas are spherical or pear-shaped fruits that can be as long as 20 inches.", "₹ 85", "1", "KG", R.drawable.card3, R.drawable.b3));
        recentlyViewedList.add(new RecentlyViewed("Strawberry", "The strawberry is a highly nutritious fruit, loaded with vitamin C.", "₹ 30", "1", "KG", R.drawable.card2, R.drawable.b1));
        recentlyViewedList.add(new RecentlyViewed("Kiwi", "Full of nutrients like vitamin C, vitamin K, vitamin E, folate, and potassium.", "₹ 30", "1", "PC", R.drawable.card1, R.drawable.b2));

        setRecentlyRecycler(recentlyViewedList);

    }

    private void setDiscountRecycler(List<DiscountedProducts> dataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        discountRecyclerView.setLayoutManager(layoutManager);
        discountProductAdapter = new DiscountProductAdapter(this,dataList);
        discountRecyclerView.setAdapter(discountProductAdapter);
    }

    private void setCategoryRecycler(List<Category> categoryList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        categoryRecyclerView.setLayoutManager(layoutManager);
        categoryAdapter = new CategoryAdapter(this,categoryList);
        categoryRecyclerView.setAdapter(categoryAdapter);
    }

    private void setRecentlyRecycler(List<RecentlyViewed> recentlyViewedList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recentlyRecycler.setLayoutManager(layoutManager);
        recentlyViewedAdapter = new RecentlyViewedAdapter(this,recentlyViewedList);
        recentlyRecycler.setAdapter(recentlyViewedAdapter);
    }
}