package com.mobile.azrinurvani.e_commercesimpleexample.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.mobile.azrinurvani.e_commercesimpleexample.ProductDetailsActivity;
import com.mobile.azrinurvani.e_commercesimpleexample.R;
import com.mobile.azrinurvani.e_commercesimpleexample.model.RecentlyViewed;

import java.util.List;

public class RecentlyViewedAdapter extends RecyclerView.Adapter<RecentlyViewedAdapter.RecentlyViewHolder> {
    Context context;
    List<RecentlyViewed> dataRecentlyViewList;

    public RecentlyViewedAdapter(Context context, List<RecentlyViewed> dataRecentlyViewList) {
        this.context = context;
        this.dataRecentlyViewList = dataRecentlyViewList;
    }

    @NonNull
    @Override
    public RecentlyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recently_viewed_row_items,null,false);
        return new RecentlyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecentlyViewHolder holder, int position) {
        holder.name.setText(dataRecentlyViewList.get(position).getName());
        holder.desc.setText(dataRecentlyViewList.get(position).getDescription());
        holder.price.setText(dataRecentlyViewList.get(position).getPrice());
        holder.qty.setText(dataRecentlyViewList.get(position).getQuantity().toString());
        holder.unit.setText(dataRecentlyViewList.get(position).getUnit());

        holder.bg.setBackgroundResource(dataRecentlyViewList.get(position).getImageUrl());
        //holder.imgCard.setBackgroundResource(dataRecentlyViewList.get(position).getImageUrl());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(context, ProductDetailsActivity.class);
                i.putExtra("name", dataRecentlyViewList.get(position).getName());
                i.putExtra("image", dataRecentlyViewList.get(position).getBigimageurl());
                i.putExtra("price",dataRecentlyViewList.get(position).getPrice());
                i.putExtra("desc",dataRecentlyViewList.get(position).getDescription());
                i.putExtra("qty",dataRecentlyViewList.get(position).getQuantity());
                i.putExtra("unit",dataRecentlyViewList.get(position).getUnit());

                context.startActivity(i);

            }
        });
    }

    @Override
    public int getItemCount() {
        if (dataRecentlyViewList ==null)
            return 0;
        else
            return dataRecentlyViewList.size();
    }

    public class RecentlyViewHolder extends RecyclerView.ViewHolder {
        TextView name,desc,price,qty,unit;
        ConstraintLayout bg;
        public RecentlyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.product_name);
            desc = itemView.findViewById(R.id.description);
            price = itemView.findViewById(R.id.product_name);
            qty= itemView.findViewById(R.id.qty);
            unit = itemView.findViewById(R.id.unit);
            bg = itemView.findViewById(R.id.recently_layout);
        }
    }
}
