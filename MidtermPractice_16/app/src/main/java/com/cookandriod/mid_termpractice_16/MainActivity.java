package com.cookandriod.mid_termpractice_16;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    Button start, stop;
    ViewFlipper vf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         start = findViewById(R.id.start);
         stop = findViewById(R.id.stop);
         vf = findViewById(R.id.vf);

        vf.setFlipInterval(1000);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vf.startFlipping();
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vf.stopFlipping();
            }
        });

    }
}