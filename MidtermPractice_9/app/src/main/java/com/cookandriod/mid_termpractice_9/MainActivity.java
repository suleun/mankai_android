package com.cookandriod.mid_termpractice_9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;

import java.sql.Time;

public class MainActivity extends AppCompatActivity {

    TextView startTV, yearNum, monthNum, dateNum, minNum;
    Chronometer chronometer;
    RadioGroup RG;
    RadioButton date, time;
    DatePicker DP;
    TimePicker TP;
    LinearLayout endLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("예약 어플리 케이션");

        startTV = findViewById(R.id.startTV);
        yearNum = findViewById(R.id.yearNum);
        monthNum = findViewById(R.id.monthNum);
        dateNum= findViewById(R.id.dateNum);
        minNum = findViewById(R.id.minNum);

        chronometer = findViewById(R.id.chronometer);
        RG = findViewById(R.id.RG);
        date = findViewById(R.id.date);
        time = findViewById(R.id.time);
        DP = findViewById(R.id.DP);
        TP = findViewById(R.id.TP);
        endLayout = findViewById(R.id.endLayout);


        RG.setVisibility(View.INVISIBLE);
        DP.setVisibility(View.INVISIBLE);
        TP.setVisibility(View.INVISIBLE);

        chronometer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chronometer.start();
                RG.setVisibility(View.VISIBLE);
            }
        });


        if (date.isChecked() == true){

            DP.setVisibility(View.VISIBLE);
            TP.setVisibility(View.INVISIBLE);

        }else if(time.isChecked() == true){
            TP.setVisibility(View.VISIBLE);
            DP.setVisibility(View.INVISIBLE);

        }

      endLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chronometer.stop();
                yearNum.setText(date.getText().toString());
                monthNum.setText(date.getText().toString());
                dateNum.setText(date.getText().toString());
                minNum.setText(date.getText().toString());


                RG.setVisibility(View.INVISIBLE);
                DP.setVisibility(View.INVISIBLE);
                TP.setVisibility(View.INVISIBLE);

            }
        });
    }
}