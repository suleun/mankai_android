package com.cookandriod.mid_termpractice_20;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
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
//        MenuInflater mInflater = getMenuInflater();
//        mInflater.inflate(R.menu.menu, menu);

        menu.add(0,1,0,"배경색 빨강");
        menu.add(0,2,0,"배경색 초록");
        menu.add(0,3,0,"배경색 파랑");

        SubMenu sMenu = menu.addSubMenu("버튼변경");
        sMenu.add(0,4,0,"버튼 2배 확대");
        sMenu.add(0,5,0,"버튼45도 회전");


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case 1:
                baseLayout.setBackgroundColor(Color.RED);
                return true;
            case 2:
                baseLayout.setBackgroundColor(Color.GREEN);
                return true;
            case 3:
                baseLayout.setBackgroundColor(Color.BLUE);
                return true;
            case 4:
                btn.setScaleX(2);
                btn.setScaleY(2);
                return true;
            case 5:
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