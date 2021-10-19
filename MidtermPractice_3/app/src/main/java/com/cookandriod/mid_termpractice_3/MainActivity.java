package com.cookandriod.mid_termpractice_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.net.InterfaceAddress;

public class MainActivity extends AppCompatActivity {

    EditText edt1, edt2;
    Button add, minus, nanugi, goppagi ;
    TextView resultTV;
    String num1, num2;
    Integer result;
    Button[] numButtons = new Button[10];
    Integer[] numBtnIDs = {
            R.id.btn0,
            R.id.btn1,
            R.id.btn2,
            R.id.btn3,
            R.id.btn4,
            R.id.btn5,
            R.id.btn6,
            R.id.btn7,
            R.id.btn8,
            R.id.btn9
    };

    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("테이블 레이아웃 계산기");

        edt1 = (EditText)findViewById(R.id.edt1);
        edt2 = (EditText)findViewById(R.id.edt2);

        add = (Button)findViewById(R.id.add);
        minus = (Button)findViewById(R.id.minus);
        nanugi = (Button)findViewById(R.id.nanugi);
        goppagi = (Button)findViewById(R.id.goppagi);

        resultTV = (TextView)findViewById(R.id.resultTV);


        add.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                num1 = edt1.getText().toString();
                num2 = edt2.getText().toString();
                result = Integer.parseInt(num1) + Integer.parseInt(num2);
                resultTV.setText("계산 결과 : " + result.toString());
                return false;
            }
        });

        minus.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                num1 = edt1.getText().toString();
                num2 = edt2.getText().toString();
                result = Integer.parseInt(num1) - Integer.parseInt(num2);
                resultTV.setText("계산 결과 : " + result.toString());
                return false;
            }
        });

        nanugi.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                num1 = edt1.getText().toString();
                num2 = edt2.getText().toString();
                result = Integer.parseInt(num1) / Integer.parseInt(num2);
                resultTV.setText("계산 결과 : " + result.toString());
                return false;
            }
        });

        goppagi.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                num1 = edt1.getText().toString();
                num2 = edt2.getText().toString();
                result = Integer.parseInt(num1) * Integer.parseInt(num2);
                resultTV.setText("계산 결과 : " + result.toString());
                return false;
            }
        });

        for( i = 0 ; i<numBtnIDs.length ; i++ ){
            numButtons[i] = (Button)findViewById(numBtnIDs[i]);
        }

        for ( i = 0 ; i < numBtnIDs.length ; i++){
            final int index;
            index = i;

            numButtons[index].setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    if (edt1.isFocused() == true){
                        num1 = edt1.getText().toString() + numButtons[index].getText().toString();
                        edt1.setText(num1);
                    }else if (edt2.isFocused() == true){
                        num2 = edt2.getText().toString() + numButtons[index].getText().toString();
                        edt2.setText(num2);
                    }else{
                        Toast.makeText(getApplicationContext(), "먼저 에디트 텍스트를 선택 하세요", Toast.LENGTH_SHORT).show();
                    }
                }
            });


        }


    }
}