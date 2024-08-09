package com.example.axforasset;

import android.content.Context;
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

    public ItemAdapter(List<Item> itemList, Context context) {
        this.itemList = itemList;
        this.context = context;
    }

        @NonNull
        @Override
        public ItemViewHolder onCreateViewHolder (@NonNull ViewGroup parent,int viewType){

            View view = LayoutInflater.from(context).inflate(R.layout.card_items, parent, false);

//         View view = LayoutInflater.from(context).inflate(R.layout.item_card, parent, false);

            return new ItemViewHolder(view);
        }

        @Override
        public void onBindViewHolder (@NonNull ItemViewHolder holder,int position){
            Item item = itemList.get(position);

            holder.itemName.setText(item.getName());
            holder.itemDescription.setText(item.getDescription());
            holder.itemPrice.setText(item.getPrice());
            holder.itemImage.setImageResource(item.getImageResourceId());

//         holder.imageView.setImageResource(item.getImageResource());
//         holder.titleTextView.setText(item.getTitle());
//         holder.descriptionTextView.setText(item.getDescription());
//         holder.priceTextView.setText("$" + item.getPrice());

            holder.detailButton.setOnClickListener(v -> {
                // Handle detail button click

            });

        }

        @Override
        public int getItemCount () {
            return itemList.size();
        }

        public static class ItemViewHolder extends RecyclerView.ViewHolder {

            TextView itemName, itemDescription, itemPrice;
            ImageView itemImage;
            ImageView imageView;
            TextView titleTextView;
            TextView descriptionTextView;
            TextView priceTextView;

            Button detailButton;

            public ItemViewHolder(@NonNull View itemView) {
                super(itemView);
             itemName = itemView.findViewById(R.id.itemName);
             itemDescription = itemView.findViewById(R.id.itemDescription);
             itemPrice = itemView.findViewById(R.id.itemPrice);
             itemImage = itemView.findViewById(R.id.itemImage);
             detailButton = itemView.findViewById(R.id.detailButton);

//                imageView = itemView.findViewById(R.id.item_image);
//                titleTextView = itemView.findViewById(R.id.item_title);
//                descriptionTextView = itemView.findViewById(R.id.item_description);
//                priceTextView = itemView.findViewById(R.id.item_price);
//                detailButton = itemView.findViewById(R.id.item_detail_button);
            }
        }
    }
