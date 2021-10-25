package com.cookandriod.mid_termpractice_20;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.style.BackgroundColorSpan;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    LinearLayout baseLayout;
    Button btn1, btn2;
    Integer rotation = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("컨텍스트 메뉴");


        baseLayout = findViewById(R.id.baseLayout);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);

        registerForContextMenu(btn1);
        registerForContextMenu(btn2);


    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater mInflater = getMenuInflater();

        if (v == btn1) {
            mInflater.inflate(R.menu.menu, menu);
        } else if (v == btn2) {
            mInflater.inflate(R.menu.menu1, menu);
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
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
            case R.id.btnR:
                rotation = rotation + 45;
                btn2.setRotation(rotation);
                return true;
            case R.id.btnS:
                btn2.setScaleX(2);
                btn2.setScaleY(2);
                return true;
        }
        return false;
    }
}

