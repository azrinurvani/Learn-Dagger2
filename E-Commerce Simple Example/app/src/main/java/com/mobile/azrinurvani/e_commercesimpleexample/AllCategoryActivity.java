package com.mobile.azrinurvani.e_commercesimpleexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;

import com.mobile.azrinurvani.e_commercesimpleexample.adapter.AllCategoryAdapter;
import com.mobile.azrinurvani.e_commercesimpleexample.adapter.CategoryAdapter;
import com.mobile.azrinurvani.e_commercesimpleexample.model.AllCategory;
import com.mobile.azrinurvani.e_commercesimpleexample.model.Category;

import java.util.ArrayList;
import java.util.List;

public class AllCategoryActivity extends AppCompatActivity {

    RecyclerView allCategoryRecycler;
    AllCategoryAdapter allCategoryAdapter;
    List<AllCategory> allCategoryList;

    ImageView imgCart,backImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_category);

        allCategoryRecycler = findViewById(R.id.allCategoryRecycler);
        imgCart = findViewById(R.id.cartImage);
        backImg = findViewById(R.id.backImage);

        allCategoryList = new ArrayList<>();
        allCategoryList.add(new AllCategory(1,R.drawable.ic_fruits));
        allCategoryList.add(new AllCategory(2,R.drawable.ic_fish));
        allCategoryList.add(new AllCategory(3,R.drawable.ic_meat));
        allCategoryList.add(new AllCategory(4,R.drawable.ic_egg));
        allCategoryList.add(new AllCategory(5,R.drawable.ic_spices));
        allCategoryList.add(new AllCategory(6,R.drawable.ic_egg));
        allCategoryList.add(new AllCategory(7,R.drawable.ic_drink));
        allCategoryList.add(new AllCategory(8,R.drawable.ic_juce));
        allCategoryList.add(new AllCategory(9,R.drawable.ic_cookies));
        setAllCategoryRecycler(allCategoryList);


    }

    private void setAllCategoryRecycler(List<AllCategory> categoryList) {
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,3);
        allCategoryRecycler.setLayoutManager(layoutManager);
        allCategoryRecycler.addItemDecoration(new GridSpacingItemDecoration(4,dpToPx(16),true));
        allCategoryRecycler.setItemAnimator(new DefaultItemAnimator());
        allCategoryAdapter = new AllCategoryAdapter(this,categoryList);
        allCategoryRecycler.setAdapter(allCategoryAdapter);
    }


    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}