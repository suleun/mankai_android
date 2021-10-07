package com.cookandriod.date_time_reservation_app;

import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {


    Chronometer chronometer;
    Button startBtn, endBtn;
    RadioButton radioC, radioT;
    CalendarView calnedarV;
    TimePicker Time;
    TextView Y, M, D, H, m;

    int selectYear, selectMonth, selectDay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("시간예약");

        startBtn = (Button) findViewById(R.id.startBtn);
        endBtn = (Button) findViewById(R.id.endBtn);

        chronometer = (Chronometer) findViewById(R.id.chronometer);

        radioC = (RadioButton) findViewById(R.id.radioC);
        radioT = (RadioButton) findViewById(R.id.radioT);

        calnedarV = (CalendarView) findViewById(R.id.calnedarV);
        Time = (TimePicker) findViewById(R.id.Time);


        Y = (TextView) findViewById(R.id.Y);
        M = (TextView) findViewById(R.id.M);
        D = (TextView) findViewById(R.id.D);
        H = (TextView) findViewById(R.id.H);
        m = (TextView) findViewById(R.id.m);


        calnedarV.setVisibility(View.INVISIBLE);
        Time.setVisibility(View.INVISIBLE);

        radioC.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calnedarV.setVisibility(View.VISIBLE);
                Time.setVisibility(View.INVISIBLE);
            }
        });

        radioT.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calnedarV.setVisibility(View.INVISIBLE);
                Time.setVisibility(View.VISIBLE);
            }
        });


        startBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();
                chronometer.setTextColor(Color.RED);
            }
        });

        endBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chronometer.stop();
                chronometer.setTextColor(Color.BLUE);

                Y.setText(Integer.toString(selectYear));
                M.setText(Integer.toString(selectMonth));
                D.setText(Integer.toString(selectDay));

                H.setText(Integer.toString(Time.getCurrentHour()));
                m.setText(Integer.toString(Time.getCurrentMinute()));



            }
        });

        calnedarV.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                selectYear = year;
                selectMonth = month + 1;
                selectDay = dayOfMonth;
            }
        });

    }
}