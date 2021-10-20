package com.cookandriod.mid_termpractice_5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Switch Sstart;


    TextView TV2;

    RadioGroup RG;

    RadioButton Rbtn1, Rbtn2, Rbtn3;

    ImageView imageV;

    Button btnEnd, btn0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("안드로이드 사진보기");

        Sstart = findViewById(R.id.Sstart);
        TV2 = findViewById(R.id.TV2);
        RG = findViewById(R.id.RG);
        Rbtn1 = findViewById(R.id.Rbtn1);
        Rbtn2 = findViewById(R.id.Rbtn2);
        Rbtn3 = findViewById(R.id.Rbtn3);
        imageV = findViewById(R.id.imageV);
        btn0 = findViewById(R.id.btn0);
        btnEnd = findViewById(R.id.btnEnd);

        TV2.setVisibility(View.INVISIBLE);
        RG.setVisibility(View.INVISIBLE);
        imageV.setVisibility(View.INVISIBLE);
        btn0.setVisibility(View.INVISIBLE);
        btnEnd.setVisibility(View.INVISIBLE);


        Sstart.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (Sstart.isChecked() == false) {
                    TV2.setVisibility(View.INVISIBLE);
                    RG.setVisibility(View.INVISIBLE);
                    imageV.setVisibility(View.INVISIBLE);
                    btn0.setVisibility(View.INVISIBLE);
                    btnEnd.setVisibility(View.INVISIBLE);
                } else if (Sstart.isChecked() == true) {
                    TV2.setVisibility(View.VISIBLE);
                    RG.setVisibility(View.VISIBLE);
                    btn0.setVisibility(View.VISIBLE);
                    btnEnd.setVisibility(View.VISIBLE);
                }
            }
        });



        Rbtn1.setOnClickListener(radio_listener);
        Rbtn2.setOnClickListener(radio_listener);
        Rbtn3.setOnClickListener(radio_listener);


        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TV2.setVisibility(View.INVISIBLE);
                RG.setVisibility(View.INVISIBLE);
                imageV.setVisibility(View.INVISIBLE);
                btn0.setVisibility(View.INVISIBLE);
                btnEnd.setVisibility(View.INVISIBLE);
                Sstart.setChecked(false);

                Rbtn1.setChecked(false);
                Rbtn2.setChecked(false);
                Rbtn3.setChecked(false);
            }
        });

    }

    View.OnClickListener radio_listener = new View.OnClickListener() {

        public void onClick(View arg0) {

            if (Rbtn1.isChecked()) {
                imageV.setImageResource(R.drawable.pie);
                imageV.setVisibility(View.VISIBLE);
            } else if (Rbtn2.isChecked()) {
                imageV.setImageResource(R.drawable.q10);
                imageV.setVisibility(View.VISIBLE);
            } else if (Rbtn3.isChecked()) {
                imageV.setImageResource(R.drawable.r11);
                imageV.setVisibility(View.VISIBLE);
            } else {
                Toast.makeText(getApplicationContext(), "안드로이드 버전 먼저 선택 하세요", Toast.LENGTH_SHORT).show();
            }

        }
    };

}