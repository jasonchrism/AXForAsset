package com.example.axforasset;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class PageDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_detail);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Inisialisasi Spinner dan Button
        Spinner paymentMethodSpinner = findViewById(R.id.paymentMethodSpinner);
        Button submitButton = findViewById(R.id.submitButton);

        // Inisialisasi EditText
        EditText editTextName = findViewById(R.id.emailInput);

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
                // Ambil nama dari EditText
                String name = editTextName.getText().toString();
                AlertDialog.Builder builder = new AlertDialog.Builder(PageDetail.this);
                if (name.isEmpty()) {
                    builder.setTitle("Submission Failed");
                    builder.setMessage("Please fill in your email address");
                } else if (paymentMethodSpinner.getSelectedItem().toString().equals("Choose Payment")) {
                    builder.setTitle("Submission Failed");
                    builder.setMessage("Please choose your payment method");
                } else {
                    builder.setTitle("Submission Success");
                    builder.setMessage("A confirmation email has been sent to your provided email address. Please check your inbox");
                }
                builder.setPositiveButton("CLOSE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
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
}