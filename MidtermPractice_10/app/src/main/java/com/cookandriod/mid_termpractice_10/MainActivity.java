package com.cookandriod.mid_termpractice_10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] items = {
                "CSI-뉴욕",
                "CSI-라스베가스",
                "CSI-마이애미",
                "Friends",
                "Fringe",
                "Lost"
        };

        AutoCompleteTextView auto = (AutoCompleteTextView) findViewById(R.id.auto1);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, items);
        auto.setAdapter(adapter);

        // 멀티 자동완성 텍스트 뷰
        MultiAutoCompleteTextView multi = (MultiAutoCompleteTextView)findViewById(R.id.multiAuto);
        MultiAutoCompleteTextView.CommaTokenizer token = new MultiAutoCompleteTextView.CommaTokenizer();

        multi.setTokenizer(token);
        multi.setAdapter(adapter);

    }
}