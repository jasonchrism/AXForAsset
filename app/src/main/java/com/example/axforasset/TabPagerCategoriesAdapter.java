package com.example.axforasset;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class TabPagerCategoriesAdapter extends FragmentPagerAdapter {
    private int tabCount;
    public TabPagerCategoriesAdapter(@NonNull FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0){
            return new AllItemsFragment();
        } else if (position == 1) {
            return new CharactersFragment();
        } else if (position == 2) {
            return new CostumeFragment();
        } else if (position == 3) {
            return new ObjectsFragment();
        } else if (position == 4) {
            return new VehiclesFragment();
        } else if (position == 5) {
            return new WeaponsFragment();
        }

        return null;
    }

    @Override
    public int getCount() {
        return 6;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(position == 0){
            return "All Items";
        } else if (position == 1) {
            return "Characters";
        } else if (position == 2) {
            return "Costume";
        } else if (position == 3) {
            return "Objects";
        } else if (position == 4) {
            return  "Vehicles";
        } else if (position == 5) {
            return "Weapons";
        }
        return null;
    }
}
