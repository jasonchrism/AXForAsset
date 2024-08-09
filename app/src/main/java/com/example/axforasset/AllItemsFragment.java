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

public class AllItemsFragment extends Fragment {

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
        items.add(new Item("Classic Dress","$90.75", "Timeless elegance wrapped in a single outfit", R.drawable.classic_dress));
        items.add(new Item("Leather Jacket","$85.67", "Rugged style for the fearless",R.drawable.leather_jacket));
        items.add(new Item("Harley Quinn","$59.67", "Embrace the madness with this iconic look", R.drawable.harley_queen));
        items.add(new Item("Safety Vest","$78.67", "Stay protected while looking sharp", R.drawable.safety_vest));
        items.add(new Item("Dragon Slayer","$85.75", "Battle-ready hero with a legacy of slaying dragons", R.drawable.dragon_slayer));
        items.add(new Item("Elite Archer","$57.55", "Precision and skill meet in this marter archer",R.drawable.elite_archer));
        items.add(new Item("Spartan Hotplite","$35.77", "Ancient warrior with unmatched bravery", R.drawable.spartan));
        items.add(new Item("The Warrior","$50.47", "A fearless combatant ready for any challenge", R.drawable.the_warrior));
        items.add(new Item("Pugeot 205","$105.79", "Compact yet powerful, a classic in the streets", R.drawable.pugeot_205));
        items.add(new Item("Dodge Charger","$97.59", "Muscle and style combine in this iconic ride",R.drawable.dodge_charger));
        items.add(new Item("Chevrolet Impala","$15.78", "The smooth, classic drive for any journey", R.drawable.chevrolet_impala));
        items.add(new Item("Charger Faster","$10.67", "Speed and power for the ultimate race", R.drawable.chrager_faster));
        items.add(new Item("Moonlight Sword","$15.27", "A blade forget from the light of the moon", R.drawable.moonlight_sowrd));
        items.add(new Item("Top Guns AsiaAfrica","$27.95", "Elite firepower from two continents",R.drawable.top_guns_asiaafrica));
        items.add(new Item("Ghost Guns","$45.86", "Weapons that strike without a trace", R.drawable.ghost));
        items.add(new Item("Shadow Piercer","$59.75", "Stealthy and lethal, the ultimate assassin's tool", R.drawable.shadow_piercer));
        items.add(new Item("Fantasy Terrain","$45.75", "A mystical landscape for epic adventures", R.drawable.fantasy_terrain));
        items.add(new Item("Shatter Stone","$58.86", "A powerful artifact that can break anything",R.drawable.shatter_stone));
        items.add(new Item("Science Hospital","$49.78", "Cutting-edge medical facility for the future", R.drawable.scifi_hospital));
        items.add(new Item("Vegetation 2","$60.67", "Lush greenery to bring life to any environment", R.drawable.vegetation2));
        return items;
    }
}
