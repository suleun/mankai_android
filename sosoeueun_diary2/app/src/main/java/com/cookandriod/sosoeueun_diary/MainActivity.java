package com.cookandriod.sosoeueun_diary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;


public class MainActivity extends AppCompatActivity {


    ChipNavigationBar menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("일기장");


        menu = findViewById(R.id.menu);

        menu.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int id) {
                if (id == R.id.home) {

                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container, new emotion()).commit();

                } else if (id == R.id.write) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container, new write()).commit();
                }
            }
        });
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, new emotion()).commit();
        }


    }


}