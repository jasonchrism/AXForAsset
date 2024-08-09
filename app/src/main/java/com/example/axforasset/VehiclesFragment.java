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
        items.add(new Item("Pugeot 205","$105.79", "Kunai sakti mata tajam biru pencabut nyawa", R.drawable.pugeot_205));
        items.add(new Item("Dodge Charger","$97.59", "Mau aku tembak ga seng? Tembakan paling keren",R.drawable.dodge_charger));
        items.add(new Item("Chevrolet Impala","$15.78", "3D aset mobil terbaik di dunia mantap", R.drawable.chevrolet_impala));
        items.add(new Item("Charger Faster","$10.67", "Mobil hitam jetblack siap tempur nih ngab", R.drawable.chrager_faster));
        return items;
    }
}
