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

public class ObjectsFragment extends Fragment {

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
        items.add(new Item("Fantasy Terrain","$45.75", "Pilihan tanah yang beraneka ragam", R.drawable.fantasy_terrain));
        items.add(new Item("Shatter Stone","$58.86", "Pilihan batu mineral poseidon",R.drawable.shatter_stone));
        items.add(new Item("Science Hospital","$49.78", "Ruangan-ruangan yang ada di Rumah Sakit", R.drawable.scifi_hospital));
        items.add(new Item("Vegetation 2","$60.67", "Kumpulan tanaman dan tumbuhan hijau", R.drawable.vegetation2));
        return items;
    }
}
