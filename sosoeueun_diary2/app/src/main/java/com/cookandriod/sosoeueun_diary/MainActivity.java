package com.cookandriod.sosoeueun_diary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;


public class MainActivity extends AppCompatActivity {


    ChipNavigationBar menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("간단한 일기장");


        menu = findViewById(R.id.menu);

        menu.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int id) {
                if (id == R.id.home) {

                    System.out.println("홈 클릭됨");
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container, new emotion()).commit();

                } else if (id == R.id.write) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container, new write()).commit();

                    System.out.println(" 쓰기 클릭됨");


                } else if (id == R.id.memorial) {


                    System.out.println(" 기억 클릭됨");
                }
            }
        });
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, new emotion()).commit();
        }


    }


}