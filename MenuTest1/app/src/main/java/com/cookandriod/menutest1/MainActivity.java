package com.cookandriod.menutest1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2;
    LinearLayout baseLayout;
    int rotation = 45;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        baseLayout = (LinearLayout)findViewById(R.id.baseLayout);

        setTitle("배경색 바꾸기");

        registerForContextMenu(btn1);
        registerForContextMenu(btn2);

    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater mInflater = getMenuInflater();
       if (v == btn1){
           mInflater.inflate(R.menu.menu, menu);
       } else if(v == btn2){
           mInflater.inflate(R.menu.menu2, menu);
       }
    }


    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.itemRed:
                baseLayout.setBackgroundColor(Color.RED);
                return true;

            case R.id.itemGreen:
                baseLayout.setBackgroundColor(Color.GREEN);
                return true;

            case R.id.itemBlue:
                baseLayout.setBackgroundColor(Color.BLUE);
                return true;

            case R.id.subRotate:
                btn2.setRotation(rotation);
                rotation = rotation + 45 ;
                return true;

            case R.id.subRotate0:
                btn2.setRotation(0);

                btn2.setScaleX(1);
                btn2.setScaleY(1);
                return true;

            case R.id.subSize:
                btn2.setScaleX(2);
                btn2.setScaleY(2);
                return true;
        }
        return false;

    }


}