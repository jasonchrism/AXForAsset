package com.example.axforasset;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

public class ProfileActivity extends AppCompatActivity {

    Toolbar toolbar;
    Button backBtn;
    Button hamburgetBtn;
    RelativeLayout rlMenu;
    Menu home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        rlMenu = findViewById(R.id.rlMenu);
        backBtn = findViewById(R.id.backBtn);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                Toast.makeText(this, "Home Clicked", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.items:
                Toast.makeText(this, "Items Clicked", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.logout:
                Toast.makeText(this, "Log out Clicked", Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}