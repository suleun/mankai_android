package com.cookandriod.mid_termpractice_15;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button back, go;
        final ViewFlipper vf;

        back = findViewById(R.id.back);
        go = findViewById(R.id.go);
        vf = findViewById(R.id.vf);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vf.showPrevious();
            }
        });

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vf.showNext();
            }
        });
    }
}