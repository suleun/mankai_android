package com.cookandriod.mid_termpractice_7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button page1, page2;
    ImageView dog, cat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        page1 = findViewById(R.id.page1);
        page2 = findViewById(R.id.page2);

        dog = findViewById(R.id.dog);
        cat = findViewById(R.id.cat);

        dog.setVisibility(View.INVISIBLE);
        cat.setVisibility(View.INVISIBLE);

        page1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                dog.setVisibility(View.VISIBLE);
                cat.setVisibility(View.INVISIBLE);
            }
        });

        page2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                dog.setVisibility(View.INVISIBLE);
                cat.setVisibility(View.VISIBLE);
            }
        });

    }
}