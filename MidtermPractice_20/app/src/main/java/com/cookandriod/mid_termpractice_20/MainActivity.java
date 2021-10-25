package com.cookandriod.mid_termpractice_20;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    LinearLayout baseLayout;
    Button btn;
    Integer rotation = 45;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater mInflater = getMenuInflater();
        mInflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.red:
                baseLayout.setBackgroundColor(Color.RED);
                return true;
            case R.id.green:
                baseLayout.setBackgroundColor(Color.GREEN);
                return true;
            case R.id.blue:
                baseLayout.setBackgroundColor(Color.BLUE);
                return true;
            case R.id.btn2:
                btn.setScaleX(2);
                btn.setScaleY(2);
                return true;
            case R.id.btnR:
                btn.setRotation(rotation);
                rotation = rotation + 45;
        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("메뉴");


        baseLayout = findViewById(R.id.baseLayout);
        btn = findViewById(R.id.btn);


    }
}