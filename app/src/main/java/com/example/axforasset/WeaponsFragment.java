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

public class WeaponsFragment extends Fragment {

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
        items.add(new Item("Moonlight Sword","$15.27", "Pedang yang seperti cahaya bulan", R.drawable.moonlight_sowrd));
        items.add(new Item("Top Guns AsiaAfrica","$27.95", "Mau aku tembak ga seng? Tembakan paling keren",R.drawable.top_guns_asiaafrica));
        items.add(new Item("Ghost Guns","$45.86", "Siap menembak dengan banyak peluru", R.drawable.ghost));
        items.add(new Item("Shadow Piercer","$59.75", "Siap melakukan headshot kepada musuh", R.drawable.shadow_piercer));
        return items;
    }
}
