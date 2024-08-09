package com.example.axforasset;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class VehiclesFragment extends Fragment {

    private RecyclerView recyclerView;
    private ItemAdapter itemAdapter;
    private List<Item> itemList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_all_items, container, false);

        recyclerView = view.findViewById(R.id.recycleViewAllItems);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new ItemAdapter(getItems(), getContext()));
        recyclerView.setNestedScrollingEnabled(true);

        itemList = getItems();
        itemAdapter = new ItemAdapter(itemList, getContext());

        return view;
    }

    private List<Item> getItems() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Pugeot 205","$105.79", "Compact yet powerful, a classic in the streets", R.drawable.pugeot_205));
        items.add(new Item("Dodge Charger","$97.59", "Muscle and style combine in this iconic ride",R.drawable.dodge_charger));
        items.add(new Item("Chevrolet Impala","$15.78", "The smooth, classic drive for any journey", R.drawable.chevrolet_impala));
        items.add(new Item("Charger Faster","$10.67", "Speed and power for the ultimate race", R.drawable.chrager_faster));
        return items;
    }
}
