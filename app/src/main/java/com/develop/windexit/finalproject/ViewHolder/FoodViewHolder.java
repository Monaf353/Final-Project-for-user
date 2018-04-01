package com.develop.windexit.finalproject.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.develop.windexit.finalproject.Interface.ItemCliclListener;
import com.develop.windexit.finalproject.R;

/**
 * Created by WINDEX IT on 16-Feb-18.
 */

public class FoodViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView food_name,food_price;
    public ImageView food_image,fav_image,btnShare,btn_quick_cart;

    private ItemCliclListener itemCliclListener;

    public FoodViewHolder(View itemView) {
        super(itemView);

        food_name =  itemView.findViewById(R.id.food_name);
        food_image =  itemView.findViewById(R.id.food_image);
        fav_image =  itemView.findViewById(R.id.fav);
        btnShare = itemView.findViewById(R.id.btnShare);
        food_price = itemView.findViewById(R.id.food_price);
        btn_quick_cart = itemView.findViewById(R.id.btn_quick_cart);

        itemView.setOnClickListener(this);
    }


    public void setItemCliclListener(ItemCliclListener itemCliclListener) {
        this.itemCliclListener = itemCliclListener;
    }

    @Override
    public void onClick(View v) {
        itemCliclListener.onClick(v, getAdapterPosition(), false);

    }
}
