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

public class CharactersFragment extends Fragment {

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
        items.add(new Item("Dragon Slayer","$85.75", "Penunggang naga dari anime Demon Slayer", R.drawable.dragon_slayer));
        items.add(new Item("Elite Archer","$57.55", "Mau aku tembak panah seng? Pemanah keren",R.drawable.elite_archer));
        items.add(new Item("Spartan Hotplite","$35.77", "Samurai penebas pedang yang siap menyelamatkan", R.drawable.spartan));
        items.add(new Item("The Warrior","$50.47", "Malaikat dari Surga yang siap menyucikan Anda!", R.drawable.the_warrior));
        return items;
    }
}
