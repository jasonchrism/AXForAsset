package com.example.axforasset;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    TextView tvGreeting1;

    String username;

    private ViewPager2 viewPager2;
    private Handler sliderHandler = new Handler();
    private RecyclerView recyclerView;
    private ItemAdapter itemAdapter;
    private List<Item> itemList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tvGreeting1 = findViewById(R.id.tvGreeting1);

        Intent i = getIntent();
        username = i.getStringExtra("username");
        tvGreeting1.setText("Welcome, " + username);

        // carousel
        viewPager2 = findViewById(R.id.viewPagerCarousel);
        List<SliderItem> sliderItems = new ArrayList<>();
        sliderItems.add(new SliderItem(R.drawable.banner1));
        sliderItems.add(new SliderItem(R.drawable.banner2));
        sliderItems.add(new SliderItem(R.drawable.banner3));

        viewPager2.setAdapter(new SliderAdapter(sliderItems, viewPager2));
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                sliderHandler.removeCallbacks(sliderRunnable);
                sliderHandler.postDelayed(sliderRunnable, 3000);
            }
        });

        TextView tvViewMore = findViewById(R.id.text_view_more);
        tvViewMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iItems = new Intent(HomeActivity.this, ItemsActivity.class);
                startActivity(iItems);
            }
        });

        // card item
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        itemList = new ArrayList<>();
        itemList.add(new Item("Kunai Honai", "$100", "Kunai sakti mata tajam biru pencabut nyawa", R.drawable.kunai));
        itemList.add(new Item("Top Gun Asia", "$90.44", "Mau aku tembak ga", R.drawable.top_gun));
        itemList.add(new Item("Chevrolet Impala", "$55.67", "3D aset mobil terbaik di dunia mantap", R.drawable.chevrolet_impala));
        itemList.add(new Item( "Chrager Faster", "$75.88","Mobil hitam jetblack siap tempur nih ngab", R.drawable.dodge_charger));
        // Add more items as needed

        itemAdapter = new ItemAdapter(itemList, this);
        recyclerView.setAdapter(itemAdapter);

        // tab
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        ViewPager2 viewPager = findViewById(R.id.view_pager);

        ViewPagerHomeAdapter adapter = new ViewPagerHomeAdapter(this);
        viewPager.setAdapter(adapter);


        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText("Terms");
                    break;
                case 1:
                    tab.setText("Conditions");
                    break;
            }
        }).attach();

        tabLayout.getViewTreeObserver().addOnGlobalLayoutListener(() -> {
            Typeface typeface = ResourcesCompat.getFont(this, R.font.poppins_semibold);

            for (int j = 0; j < tabLayout.getTabCount(); j++) {
                TabLayout.Tab tab = tabLayout.getTabAt(j);
                if (tab != null) {
                    LinearLayout tabView = (LinearLayout) ((ViewGroup) tabLayout.getChildAt(0)).getChildAt(j);
                    TextView tabTextView = (TextView) tabView.getChildAt(1); // Find TextView by index

                    if (tabTextView != null) {
                        tabTextView.setTypeface(typeface);
                        tabTextView.setLetterSpacing(0);
                        tabTextView.setAllCaps(false);
                    }
                }
            }
        });

    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_home_item, menu);
        return true;
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.items:
                Intent iItems = new Intent(HomeActivity.this, ItemsActivity.class);
                startActivity(iItems);
                break;

            case R.id.profile:
                Intent iProfile = new Intent(HomeActivity.this, ProfileActivity.class);
                iProfile.putExtra("username", username);
                startActivity(iProfile);
                break;

            case R.id.logout:
                Intent iLogout = new Intent(HomeActivity.this, LoginActivity.class);
                startActivity(iLogout);
                break;

            default:
                return super.onOptionsItemSelected(item);
        }
        return false;
    }
    private Runnable sliderRunnable = new Runnable() {
        @Override
        public void run() {
            viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
        }
    };
}