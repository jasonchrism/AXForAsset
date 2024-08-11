package com.example.axforasset;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class PageDetail extends AppCompatActivity {

    String username;
    boolean state = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_detail);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent i = getIntent();
        username = i.getStringExtra("username");
        System.out.println(username);

        // set the value
        Intent iDetail = getIntent();
        String name = iDetail.getStringExtra("item_name");
        String price = iDetail.getStringExtra("item_price");
        int itemImageResourceId = iDetail.getIntExtra("item_image", -1);
        String desc = iDetail.getStringExtra("item_desc");
        TextView itemName = findViewById(R.id.productName);
        TextView itemPrice = findViewById(R.id.productPrice);
        TextView itemDesc = findViewById(R.id.productDescription);
        ImageView imageView = findViewById(R.id.productImage);
        itemName.setText(name);
        itemPrice.setText(price);
        itemDesc.setText(desc);

        if(itemImageResourceId != -1) {
            imageView.setImageResource(itemImageResourceId);
        }


        // Inisialisasi Spinner dan Button
        Spinner paymentMethodSpinner = findViewById(R.id.paymentMethodSpinner);
        Button submitButton = findViewById(R.id.submitButton);

        // Inisialisasi EditText
        EditText editTextName = findViewById(R.id.emailInput);

        Button backBtn;
        backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iHome = new Intent(PageDetail.this, HomeActivity.class);
                iHome.putExtra("username", username);
                startActivity(iHome);
            }
        });

        // Set OnItemSelectedListener untuk Spinner (opsional)
        paymentMethodSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedMethod = parent.getItemAtPosition(position).toString();
                // Lakukan sesuatu dengan selectedMethod
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Handle kasus di mana tidak ada yang dipilih
            }
        });

        // Set OnClickListener untuk Submit Button
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitButton.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(), R.color.btn_clicked));

                // Revert to the original color after a delay (e.g., 1 second)
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Change back to the original color
                        submitButton.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(), R.color.primary));
                    }
                }, 1000);
                // Ambil nama dari EditText
                String name = editTextName.getText().toString();
                AlertDialog.Builder builder = new AlertDialog.Builder(PageDetail.this);
                if (name.isEmpty()) {
                    builder.setTitle("Submission Failed");
                    builder.setMessage("Please fill in your email address");
                } else if (paymentMethodSpinner.getSelectedItem().toString().equals("Payment Method")) {
                    builder.setTitle("Submission Failed");
                    builder.setMessage("Please choose payment method");
                } else {
                    state = true;
                    builder.setTitle("Submission Success");
                    builder.setMessage("A confirmation email has been sent to your provided email address. Please check your inbox");
                }
                Intent iHome = new Intent(PageDetail.this, HomeActivity.class);
                iHome.putExtra("username", username);
                builder.setPositiveButton("CLOSE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(state){
                            startActivity(iHome);
                        }
                        dialog.dismiss();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
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
                Intent iHome = new Intent(PageDetail.this, HomeActivity.class);
                iHome.putExtra("username", username);
                startActivity(iHome);
                break;

            case R.id.profile:
                Intent iProfile = new Intent(PageDetail.this, ProfileActivity.class);
                iProfile.putExtra("username", username);
                startActivity(iProfile);
                break;

            case R.id.logout:
                Intent iLogout = new Intent(PageDetail.this, LoginActivity.class);
                startActivity(iLogout);
                break;

            default:
                return super.onOptionsItemSelected(item);
        }
        return false;
    }

}