package com.cookandriod.mid_termpractice_9;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    TextView  yearNum, monthNum, dateNum, hourNum, minNum;
    Chronometer chronometer;
    RadioGroup RG;
    RadioButton date, time;
    DatePicker DP;
    TimePicker TP;
    LinearLayout endLayout;

    int selectYear, selectMonth, selectDay;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("예약 어플리 케이션");

        yearNum = findViewById(R.id.yearNum);
        monthNum = findViewById(R.id.monthNum);
        dateNum= findViewById(R.id.dateNum);
        minNum = findViewById(R.id.minNum);

        chronometer = findViewById(R.id.chronometer);
        RG = findViewById(R.id.RG);
        date = findViewById(R.id.date);
        hourNum = findViewById(R.id.hourNum);
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
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();
                RG.setVisibility(View.VISIBLE);
            }
        });


        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DP.setVisibility(View.VISIBLE);
                TP.setVisibility(View.INVISIBLE);
            }
        });

        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TP.setVisibility(View.VISIBLE);
                DP.setVisibility(View.INVISIBLE);

            }
        });

        DP.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int year, int month, int date) {
                selectYear = year;
                selectMonth = month;
                selectDay = date;
            }
        });



      endLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chronometer.stop();
                yearNum.setText(Integer.toString(selectYear));
                monthNum.setText(Integer.toString( selectMonth+ 1));
                dateNum.setText(Integer.toString(selectDay));

                hourNum.setText(Integer.toString(TP.getCurrentHour()));
                minNum.setText(Integer.toString(TP.getCurrentMinute()));


                RG.setVisibility(View.INVISIBLE);
                DP.setVisibility(View.INVISIBLE);
                TP.setVisibility(View.INVISIBLE);

            }
        });
    }
}