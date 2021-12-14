package com.cookandriod.sosoeueun_diary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    DatePicker dp;
    EditText editDiary;
    Button btnwrite;
    String fileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("간단한 일기장");

        dp = findViewById(R.id.datePicker1);
        editDiary = findViewById(R.id.editDiary);
        btnwrite = findViewById(R.id.btnWrite);

        Calendar cal = Calendar.getInstance();
        int cYear = cal.get(Calendar.YEAR);
        int cMonth = cal.get(Calendar.MONTH);
        int cDate = cal.get(Calendar.DAY_OF_MONTH);

        fileName = Integer.toString(cYear) + "_"
                + Integer.toString(cMonth + 1) + "_"
                + Integer.toString(cDate) + ".txt";

        String read = readDiary(fileName);
        editDiary.setText(read);

        dp.init(cYear, cMonth, cDate, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int year, int month, int day) {
                fileName = Integer.toString(year) + "_"
                        + Integer.toString(month + 1) + "_"
                        + Integer.toString(day) + ".txt";
                String str = readDiary(fileName);
                editDiary.setText(str);
                btnwrite.setEnabled(true);
            }
        });

        btnwrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileOutputStream outputS = openFileOutput(fileName, Context.MODE_PRIVATE);
                    String str = editDiary.getText().toString();
                    outputS.write(str.getBytes());
                    outputS.close();
                    Toast.makeText(getApplicationContext(), fileName + "이 저장 됨", Toast.LENGTH_SHORT).show();
                }catch(IOException e){

                }

            }
        });

    }

    String readDiary(String fName) {
        String diaryStr = null;
        FileInputStream inputS;
        try {
            inputS = openFileInput(fName);
            byte[] txt = new byte[500];
            inputS.read(txt);
            inputS.close();

            diaryStr = (new String(txt)).trim();
            btnwrite.setText("수정하기");

        } catch (IOException e) {
            editDiary.setHint("일기 없음");
            btnwrite.setHint("새로 저장");
        }

        return diaryStr;
    }
}