package com.example.axforasset;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    TextView tvGreeting1;

    String username;

    private ViewPager2 viewPager2;
    private Handler sliderHandler = new Handler();
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
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_home_item, menu);
        return true;
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.items:
                Toast.makeText(this, "Items Clicked", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.profile:
                Intent iProfile = new Intent(HomeActivity.this, ProfileActivity.class);
                iProfile.putExtra("username", username);
                startActivity(iProfile);
                break;

            case R.id.logout:
                Intent i = new Intent(HomeActivity.this, LoginActivity.class);
                startActivity(i);
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