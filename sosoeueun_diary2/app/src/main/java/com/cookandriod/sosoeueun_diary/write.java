package com.cookandriod.sosoeueun_diary;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

public class write extends Fragment {

    DatePicker dp;
    EditText editDiary;
    Button btnwrite, btnEmotion;
    String fileName;
    View inflatedview = null;
    TextView dialogTV;
    String SaveEmotion;

    public write() {
        // Required empty public constructor
    }


    String readDiary(String fName) {
        String diaryStr = null;
        FileInputStream inputS;
        try {
            inputS = getContext().openFileInput(fName);
            byte[] txt = new byte[500];
            inputS.read(txt);
            inputS.close();

            diaryStr = (new String(txt)).trim();
            btnwrite.setText("작성하기");

        } catch (IOException e) {
            editDiary.setHint("일기 없음");
            btnwrite.setHint("새로 저장");
        }

        return diaryStr;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflatedview = inflater.inflate(R.layout.fragment_write, container, false);
        // Inflate the layout for this fragment
        dp = (DatePicker) inflatedview.findViewById(R.id.datePicker1);
        editDiary = (EditText) inflatedview.findViewById(R.id.editDiary);
        btnwrite = (Button) inflatedview.findViewById(R.id.btnWrite);
        btnEmotion = (Button) inflatedview.findViewById(R.id.btnEmotion);
        dialogTV = (TextView) inflatedview.findViewById(R.id.dialogTV);


        Calendar cal = Calendar.getInstance();
        int cYear = cal.get(Calendar.YEAR);
        int cMonth = cal.get(Calendar.MONTH);
        int cDate = cal.get(Calendar.DAY_OF_MONTH);

        fileName = Integer.toString(cYear) + "_"
                + Integer.toString(cMonth + 1) + "_"
                + Integer.toString(cDate)+ "_"
                + SaveEmotion
                + ".txt";

        String read = readDiary(fileName);
        editDiary.setText(read);

        dp.init(cYear, cMonth, cDate, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int year, int month, int day) {
                fileName = Integer.toString(year) + "_"
                        + Integer.toString(month + 1) + "_"
                        + Integer.toString(day)
                        + "_"
                        + SaveEmotion
                        + ".txt";

                String str = readDiary(fileName);
                editDiary.setText(str);
                dialogTV.setText("오늘의 감정은 : " + SaveEmotion);
                btnwrite.setEnabled(true);
            }
        });

        btnwrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileOutputStream outputS = getContext().openFileOutput(fileName, Context.MODE_PRIVATE);
                    String str = editDiary.getText().toString();
                    outputS.write(str.getBytes());
                    outputS.close();
                    Toast.makeText(getContext().getApplicationContext(), fileName + "이 저장 됨", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {

                }

            }
        });

        btnEmotion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String[] emotion = new String[]{"happy", "smile", "soso", "bad", "angry"};
                AlertDialog.Builder dlg = new AlertDialog.Builder(getActivity());

                dlg.setTitle("오늘의 기분은?");
                dlg.setSingleChoiceItems(emotion, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        SaveEmotion = emotion[which];
                    }
                });
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogTV.setText("오늘의 감정은 : " + SaveEmotion);
                    }
                });
                dlg.show();

            }
        });




        return inflatedview;
    }
}