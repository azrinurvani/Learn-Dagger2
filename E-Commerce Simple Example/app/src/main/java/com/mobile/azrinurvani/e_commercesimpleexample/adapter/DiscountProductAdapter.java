package com.mobile.azrinurvani.e_commercesimpleexample.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobile.azrinurvani.e_commercesimpleexample.R;
import com.mobile.azrinurvani.e_commercesimpleexample.model.DiscountedProducts;

import java.util.List;

public class DiscountProductAdapter extends RecyclerView.Adapter<DiscountProductAdapter.DiscountProductViewHolder> {

    Context context;
    List<DiscountedProducts> discountedProductsList;

    public DiscountProductAdapter(Context context, List<DiscountedProducts> discountedProductsList) {
        this.context = context;
        this.discountedProductsList = discountedProductsList;
    }

    @NonNull
    @Override
    public DiscountProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.discount_row_items,parent,false);
        return new DiscountProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DiscountProductViewHolder holder, int position) {
        holder.discountImageView.setImageResource(discountedProductsList.get(position).getImageUrl());
    }

    @Override
    public int getItemCount() {
        if (discountedProductsList==null){
            return 0;
        }else{
            return discountedProductsList.size();
        }
    }

    public class DiscountProductViewHolder extends RecyclerView.ViewHolder {
        ImageView discountImageView;

        public DiscountProductViewHolder(@NonNull View itemView) {
            super(itemView);
            discountImageView = itemView.findViewById(R.id.discountImage);
        }
    }
}
