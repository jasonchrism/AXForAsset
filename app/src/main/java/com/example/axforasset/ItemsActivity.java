package com.example.axforasset;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;
import com.example.axforasset.Item;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;


public class ItemsActivity extends AppCompatActivity {

    androidx.appcompat.widget.Toolbar toolbar;
    Button backBtn;
    Button hamburgerBtn;

    RelativeLayout rlMenu;
    EditText searchView;
    TabLayout tabLayoutCategories;
    ViewPager viewPagerCategories;
    TabPagerCategoriesAdapter tabPagerCategoriesAdapter;

    RecyclerView recyclerViewItems;
    ItemAdapter itemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        rlMenu = findViewById(R.id.rlMenu);
        backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        searchView = findViewById(R.id.searchView);
        searchView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == EditorInfo.IME_ACTION_SEARCH || i == EditorInfo.IME_ACTION_DONE || keyEvent.getAction() == KeyEvent.ACTION_DOWN || keyEvent.getAction() == KeyEvent.KEYCODE_ENTER){
                    GoToSearchView();
                }

                return false;

            }
        });

        tabLayoutCategories = findViewById(R.id.tabLayoutCategories);
        viewPagerCategories = findViewById(R.id.viewPagerCategories);
        tabPagerCategoriesAdapter = new TabPagerCategoriesAdapter(getSupportFragmentManager(), 3);
        viewPagerCategories.setAdapter(tabPagerCategoriesAdapter);
        tabLayoutCategories.setupWithViewPager(viewPagerCategories);

        tabLayoutCategories.setTabMode(TabLayout.MODE_SCROLLABLE);

        tabLayoutCategories.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                Typeface typeface = ResourcesCompat.getFont(ItemsActivity.this, R.font.poppins_semibold);

                // Iterate through each tab and apply the font
                for (int i = 0; i < tabLayoutCategories.getTabCount(); i++) {
                    TabLayout.Tab tab = tabLayoutCategories.getTabAt(i);
                    if (tab != null && tab.getCustomView() == null) {
                        LinearLayout tabView = (LinearLayout) ((ViewGroup) tabLayoutCategories.getChildAt(0)).getChildAt(i);
                        TextView tabTextView = (TextView) tabView.getChildAt(1); // Find TextView by index

                        if (tabTextView != null) {
                            tabTextView.setTypeface(typeface);
                            tabTextView.setAllCaps(false);
                            tabTextView.setGravity(Gravity.CENTER_VERTICAL); // Center text vertically
                        }
                    }
                }

                // Remove the listener to avoid triggering it multiple times
                tabLayoutCategories.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });

        recyclerViewItems = findViewById(R.id.recyclerViewItems);
        recyclerViewItems.setLayoutManager(new LinearLayoutManager(this));
        itemAdapter = new ItemAdapter(getItems(), this);
        recyclerViewItems.setAdapter(itemAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_item2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                Intent iHome = new Intent(ItemsActivity.this, HomeActivity.class);
                startActivity(iHome);
                break;

            case R.id.profile:
                Intent iProfile = new Intent(ItemsActivity.this, ProfileActivity.class);
                startActivity(iProfile);
                break;

            case R.id.logout:
                Intent iLogout = new Intent(ItemsActivity.this, LoginActivity.class);
                startActivity(iLogout);
                break;

            default:
                return super.onOptionsItemSelected(item);
        }
        return false;
    }

    private void GoToSearchView(){
        // your Query here

    }

    private List<Item> getItems() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Kunai Honai", "$75.47", "Kunai sakit mata tajam biru pencabut nyawa", R.drawable.kunai_honai));
        items.add(new Item("Top Guns AsiaAfrica", "$27.95", "Mau aku tembak ga seng?", R.drawable.top_guns_asiaafrica));
        items.add(new Item("Chevrolet Impala", "$15.78", "3D aset mobil terbaik di dunia mantap", R.drawable.chevrolet_impala));
        items.add(new Item("Chrager Faster", "$10.67", "Mobil hitam jetblack siap tempur nih ngab", R.drawable.chrager_faster));
        // Add more items as needed
        return items;
    }
}