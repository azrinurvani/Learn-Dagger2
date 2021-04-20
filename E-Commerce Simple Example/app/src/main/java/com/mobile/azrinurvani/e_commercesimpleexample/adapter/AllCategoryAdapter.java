package com.mobile.azrinurvani.e_commercesimpleexample.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobile.azrinurvani.e_commercesimpleexample.R;
import com.mobile.azrinurvani.e_commercesimpleexample.model.AllCategory;
import com.mobile.azrinurvani.e_commercesimpleexample.model.Category;

import java.util.List;

public class AllCategoryAdapter extends RecyclerView.Adapter<AllCategoryAdapter.AllCategoryViewHolder> {

    Context context;
    List<AllCategory> dataCategory;

    public AllCategoryAdapter(Context context, List<AllCategory> dataCategory) {
        this.context = context;
        this.dataCategory = dataCategory;
    }

    @NonNull
    @Override
    public AllCategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.all_category_row_items,null,false);

        return new AllCategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AllCategoryViewHolder holder, int position) {
        holder.imgCategory.setImageResource(dataCategory.get(position).getImageUrl());
    }

    @Override
    public int getItemCount() {
        if (dataCategory==null){
            return 0;
        }else{
            return dataCategory.size();
        }

    }

    public class AllCategoryViewHolder extends RecyclerView.ViewHolder {
        ImageView imgCategory;
        public AllCategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            imgCategory = itemView.findViewById(R.id.categoryImage);
        }
    }
}
