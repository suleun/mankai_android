package com.cookandriod.pro6_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    Chronometer chronometer;
    RadioButton radioC, radioT;
    DatePicker dateP;
    TimePicker Time;
    TextView Y, M, D, H, m;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("시간예약");

        chronometer = (Chronometer) findViewById(R.id.chronometer);

        radioC = (RadioButton) findViewById(R.id.radioC);
        radioT = (RadioButton) findViewById(R.id.radioT);

        dateP = (DatePicker) findViewById(R.id.dateP);
        Time = (TimePicker) findViewById(R.id.Time);


        Y = (TextView) findViewById(R.id.Y);
        M = (TextView) findViewById(R.id.M);
        D = (TextView) findViewById(R.id.D);
        H = (TextView) findViewById(R.id.H);
        m = (TextView) findViewById(R.id.m);


        dateP.setVisibility(View.INVISIBLE);
        Time.setVisibility(View.INVISIBLE);
        radioC.setVisibility(View.INVISIBLE);
        radioT.setVisibility(View.INVISIBLE);

        chronometer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();
                chronometer.setTextColor(Color.RED);
                radioC.setVisibility(View.VISIBLE);
                radioT.setVisibility(View.VISIBLE);
            }
        });


        radioC.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dateP.setVisibility(View.VISIBLE);
                Time.setVisibility(View.INVISIBLE);
            }
        });

        radioT.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dateP.setVisibility(View.INVISIBLE);
                Time.setVisibility(View.VISIBLE);
            }
        });


        Y.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View v) {
                chronometer.stop();
                chronometer.setTextColor(Color.BLUE);

                Y.setText(Integer.toString(dateP.getYear()));
                M.setText(Integer.toString(dateP.getMonth() + 1));
                D.setText(Integer.toString(dateP.getDayOfMonth()));


                radioC.setVisibility(View.INVISIBLE);
                radioT.setVisibility(View.INVISIBLE);
                dateP.setVisibility(View.INVISIBLE);
                Time.setVisibility(View.INVISIBLE);
                return false;

            }
        });


    }
}


