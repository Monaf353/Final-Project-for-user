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

public class MenuViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView txtMenuName;
    public ImageView imageView;
    private ItemCliclListener itemCliclListener;

    public MenuViewHolder(View itemView) {
        super(itemView);

        txtMenuName =  itemView.findViewById(R.id.menu_name);
        imageView =  itemView.findViewById(R.id.menu_image);
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
