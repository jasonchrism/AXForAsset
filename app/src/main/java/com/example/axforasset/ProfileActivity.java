package com.example.axforasset;

import androidx.activity.OnBackPressedDispatcher;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

public class ProfileActivity extends AppCompatActivity {

    Toolbar toolbar;
    TextView tvGreetings;
    EditText etEmail;
    Button backBtn;
    Button hamburgetBtn;
    RelativeLayout rlMenu;
    Menu home;

    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tvGreetings = findViewById(R.id.tvGreetings);

        etEmail = findViewById(R.id.etEmail);

        Intent i = getIntent();
        username = i.getStringExtra("username");
        tvGreetings.setText("Hi, " + username + "!");
        etEmail.setText(username + "@gmail.com");

        backBtn = findViewById(R.id.backBtn);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

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
                Intent iHome = new Intent(ProfileActivity.this, HomeActivity.class);
                iHome.putExtra("username", username);
                startActivity(iHome);
                break;

            case R.id.items:
                Intent iItems = new Intent(ProfileActivity.this, ItemsActivity.class);
                startActivity(iItems);
                break;

            case R.id.logout:
                Intent iLogout = new Intent(ProfileActivity.this, LoginActivity.class);
                startActivity(iLogout);
                break;

            default:
                return super.onOptionsItemSelected(item);
        }
        return false;
    }
}