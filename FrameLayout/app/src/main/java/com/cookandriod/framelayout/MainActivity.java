package com.cookandriod.framelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView page1, page2 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        page1 = (ImageView)findViewById(R.id.dog1);
        page2 = (ImageView)findViewById(R.id.rabbit1);

        page1.setVisibility(View.INVISIBLE);
        page2.setVisibility(View.INVISIBLE);

    }


    public void onClicked(View view){
        switch (view.getId()){
            case R.id.page1 :
                page1.setVisibility(View.VISIBLE);
                page2.setVisibility(View.INVISIBLE);
                break;

            case R.id.page2 :
                page1.setVisibility(View.INVISIBLE);
                page2.setVisibility(View.VISIBLE);
                break;
        }
    }
}