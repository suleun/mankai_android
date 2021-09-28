package com.cookandriod.project_4_4;

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

public class MainActivity extends AppCompatActivity {

    TextView text1, text2;
    Switch chkSwitch;
    RadioGroup rGroup1;

    ImageView imgAnd;
    Button first, end;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("안드로이드 사진보기");

        text1 = (TextView) findViewById(R.id.Text1);
        chkSwitch = (Switch) findViewById(R.id.ChkSwitch);

        text2 = (TextView) findViewById(R.id.Text2);
        rGroup1 = (RadioGroup) findViewById(R.id.Rgroup1);

        first = (Button) findViewById(R.id.first);
        end = (Button) findViewById(R.id.end);

        //배열로 버튼 위젯 멤버 변수 선언
        RadioButton radioArray[] = new RadioButton[3];

        //배열에 버튼 위젯 대입
        radioArray[0] = (RadioButton) findViewById(R.id.RdoP);
        radioArray[1] = (RadioButton) findViewById(R.id.RdoQ);
        radioArray[2] = (RadioButton) findViewById(R.id.RdoR);

        imgAnd = (ImageView) findViewById(R.id.ImgAnd);

        // 보이는 것과 안보이는 것 설정
        chkSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (chkSwitch.isChecked() == true) {
                    text2.setVisibility(android.view.View.VISIBLE);
                    rGroup1.setVisibility(android.view.View.VISIBLE);
                    imgAnd.setVisibility(android.view.View.VISIBLE);


                } else {
                    text2.setVisibility(android.view.View.INVISIBLE);
                    rGroup1.setVisibility(android.view.View.INVISIBLE);
                    imgAnd.setVisibility(android.view.View.INVISIBLE);
                }
            }
        });


        //이미지 소스 정하는 부분

        final int draw[] = {R.drawable.pie, R.drawable.q10, R.drawable.r11};

        for (int i = 0; i < radioArray.length; i++) {
            final int index;
            index = i;
            radioArray[index].setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    imgAnd.setImageResource(draw[index]);
                }
            });
        }

        // 버튼

        first.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //  안보이게 하기
                text2.setVisibility(android.view.View.INVISIBLE);
                rGroup1.setVisibility(android.view.View.INVISIBLE);
                imgAnd.setVisibility(android.view.View.INVISIBLE);

                // 스위치 버튼 체크 없애기
                chkSwitch.setChecked(false);

                // 라디오 버튼 체크 없애기
                rGroup1.clearCheck();
            }
        });

        end.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });

    }
}