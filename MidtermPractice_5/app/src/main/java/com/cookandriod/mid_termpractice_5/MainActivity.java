package com.cookandriod.mid_termpractice_5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

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


        if (Sstart.isChecked() == true){
            TV2.setVisibility(View.VISIBLE);
            RG.setVisibility(View.VISIBLE);
            btn0.setVisibility(View.VISIBLE);
            btnEnd.setVisibility(View.VISIBLE);
        }

        if (Rbtn1.isChecked()){
            imageV.setImageDrawable('pie.png');
            imageV.setVisibility(View.VISIBLE);

        }else if(Rbtn2.isChecked()){

            imageV.setImageDrawable('q10.png');
            imageV.setVisibility(View.VISIBLE);
        } else if (Rbtn3.isChecked()) {


            imageV.setImageDrawable('r11.png');
            imageV.setVisibility(View.VISIBLE);
        }

        btnEnd.OnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btn0.OnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                TV2.setVisibility(View.INVISIBLE);
                RG.setVisibility(View.INVISIBLE);
                imageV.setVisibility(View.INVISIBLE);
                btn0.setVisibility(View.INVISIBLE);
                btnEnd.setVisibility(View.INVISIBLE);
            }
        })

    }
}