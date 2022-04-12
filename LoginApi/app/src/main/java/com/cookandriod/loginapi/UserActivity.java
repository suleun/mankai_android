package com.cookandriod.loginapi;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UserActivity extends AppCompatActivity {

    TextView tvName, tvEmail, tvCreated;
    Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        tvName = findViewById(R.id.tvName);
        tvEmail = findViewById(R.id.tvEmail);
        tvCreated = findViewById(R.id.tvCreated);

        btnLogout = findViewById(R.id.btnLogout);

        getUser();

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logout();
            }
        });

    }


    private void getUser() {
        tvName.setText("NAME : -");
        tvEmail.setText("EMAIL : -");
        tvCreated.setText("CREATED AT : -");

    }

    private void logout() {

        Intent intent = new Intent(UserActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

}