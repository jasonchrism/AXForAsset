package com.example.axforasset;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {


    private List<Item> itemList;
    private Context context;
    String username;

    public ItemAdapter(List<Item> itemList, Context context) {
        this.itemList = itemList;
        this.context = context;
    }

        @NonNull
        @Override
        public ItemViewHolder onCreateViewHolder (@NonNull ViewGroup parent,int viewType){

//            View view = LayoutInflater.from(context).inflate(R.layout.card_items, parent, false);

            View view = LayoutInflater.from(context).inflate(R.layout.item_card, parent, false);

            username = ((Activity) context).getIntent().getStringExtra("username");

            return new ItemViewHolder(view);
        }

        @Override
        public void onBindViewHolder (@NonNull ItemViewHolder holder,int position){
            Item item = itemList.get(position);

            holder.itemName.setText(item.getName());
            holder.itemDescription.setText(item.getDescription());
            holder.itemPrice.setText(item.getPrice());
            holder.itemImage.setImageResource(item.getImageResourceId());

            holder.detailButton.setOnClickListener(v -> {
                // Handle detail button click
                Intent iDetail = new Intent(v.getContext(), PageDetail.class);
                iDetail.putExtra("item_name", item.getName());
                iDetail.putExtra("item_price", item.getPrice());
                iDetail.putExtra("item_desc", item.getDescription());
                iDetail.putExtra("item_image", item.getImageResourceId());
                iDetail.putExtra("username", username);
                v.getContext().startActivity(iDetail);
            });

        }

        @Override
        public int getItemCount () {
            return itemList.size();
        }

        public static class ItemViewHolder extends RecyclerView.ViewHolder {

            TextView itemName, itemDescription, itemPrice;
            ImageView itemImage;

            Button detailButton;

            public ItemViewHolder(@NonNull View itemView) {
                super(itemView);
                itemName = itemView.findViewById(R.id.itemName);
                itemDescription = itemView.findViewById(R.id.itemDescription);
                itemPrice = itemView.findViewById(R.id.itemPrice);
                itemImage = itemView.findViewById(R.id.itemImage);
                detailButton = itemView.findViewById(R.id.detailButton);

            }
        }
    }
