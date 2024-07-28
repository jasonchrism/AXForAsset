package com.example.axforasset;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.material.button.MaterialButton;

public class LoginActivity extends AppCompatActivity {

    EditText etUsername;
    EditText etPassword;
    TextView tvUsernameError;
    TextView tvPasswordError;
    MaterialButton loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setSpannable();

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        tvUsernameError = findViewById(R.id.tvUsernameError);
        tvPasswordError = findViewById(R.id.tvPasswordError);
        loginBtn = findViewById(R.id.loginBtn);

        etUsername.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    tvUsernameError.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        etPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() >= 8) {
                    tvPasswordError.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etUsername.getText().toString().length() == 0) {
                    tvUsernameError.setVisibility(View.VISIBLE);
                } else if (etPassword.getText().toString().length() == 0) {
                    tvPasswordError.setVisibility(View.VISIBLE);
                } else if (etPassword.getText().toString().length() < 8) {
                    tvPasswordError.setVisibility(View.VISIBLE);
                    tvPasswordError.setText("Password must be at least 8 characters");
                } else {
                    Intent i = new Intent(LoginActivity.this, ProfileActivity.class);
                    i.putExtra("username", etUsername.getText().toString());
                    startActivity(i);
                }
            }
        });

    }

    public void setSpannable() {
        TextView textView = findViewById(R.id.tvRegister);
        String text = "Don't have an account? Register";
        SpannableString spannableString = new SpannableString(text);

        ForegroundColorSpan blackSpan = new ForegroundColorSpan(ContextCompat.getColor(this, R.color.black));
        spannableString.setSpan(blackSpan, 0, 22, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        ForegroundColorSpan primarySpan = new ForegroundColorSpan(ContextCompat.getColor(this, R.color.primary));
        spannableString.setSpan(primarySpan, 23, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView.setText(spannableString);
    }
}