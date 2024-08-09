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
        items.add(new Item("Classic Dress","90.75", "Mini dress tuan putri kerajaan", R.drawable.classic_dress));
        items.add(new Item("Leather Jacket","$85.67", "Jaket kulit sapi yang hangat",R.drawable.leather_jacket));
        items.add(new Item("Harley Quinn","$59.67", "Oneset Harley Quinn pacar Joker", R.drawable.harley_queen));
        items.add(new Item("Safety Vest","$78.67", "Vest yang siap melindungi kalian", R.drawable.safety_vest));
        items.add(new Item("Dragon Slayer","$85.75", "Penunggang naga dari anime Demon Slayer", R.drawable.dragon_slayer));
        items.add(new Item("Elite Archer","$57.55", "Mau aku tembak panah seng? Pemanah keren",R.drawable.elite_archer));
        items.add(new Item("Spartan Hotplite","$35.77", "Samurai penebas pedang yang siap menyelamatkan", R.drawable.spartan));
        items.add(new Item("The Warrior","$50.47", "Malaikat dari Surga yang siap menyucikan Anda!", R.drawable.the_warrior));
        items.add(new Item("Pugeot 205","$105.79", "Kunai sakti mata tajam biru pencabut nyawa", R.drawable.pugeot_205));
        items.add(new Item("Dodge Charger","$97.59", "Mau aku tembak ga seng? Tembakan paling keren",R.drawable.dodge_charger));
        items.add(new Item("Chevrolet Impala","$15.78", "3D aset mobil terbaik di dunia mantap", R.drawable.chevrolet_impala));
        items.add(new Item("Charger Faster","$10.67", "Mobil hitam jetblack siap tempur nih ngab", R.drawable.chrager_faster));
        items.add(new Item("Moonlight Sword","$15.27", "Pedang yang seperti cahaya bulan", R.drawable.moonlight_sowrd));
        items.add(new Item("Top Guns AsiaAfrica","$27.95", "Mau aku tembak ga seng? Tembakan paling keren",R.drawable.top_guns_asiaafrica));
        items.add(new Item("Ghost Guns","$45.86", "Siap menembak dengan banyak peluru", R.drawable.ghost));
        items.add(new Item("Shadow Piercer","$59.75", "Siap melakukan headshot kepada musuh", R.drawable.shadow_piercer));
        items.add(new Item("Fantasy Terrain","$45.75", "Pilihan tanah yang beraneka ragam", R.drawable.fantasy_terrain));
        items.add(new Item("Shatter Stone","$58.86", "Pilihan batu mineral poseidon",R.drawable.shatter_stone));
        items.add(new Item("Science Hospital","$49.78", "Ruangan-ruangan yang ada di Rumah Sakit", R.drawable.scifi_hospital));
        items.add(new Item("Vegetation 2","$60.67", "Kumpulan tanaman dan tumbuhan hijau", R.drawable.vegetation2));
        return items;
    }
}
