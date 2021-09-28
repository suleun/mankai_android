package com.wdj.textview_ex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1;

        btn1 = findViewById(R.id.btn1);
//        MyListenerClass lis = new MyListenerClass();
//        btn1.setOnClickListener(lis);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "클릭하셨네요", Toast.LENGTH_SHORT).show();
            }
        });

    }

//    한번 쓰고 말건데 클래스 생성이 불필요 하겠따
//    class MyListenerClass implements View.OnClickListener{
//        @Override
//        public void onClick(View view) {
//            Toast.makeText(getApplicationContext(), "클릭하셨네요", Toast.LENGTH_SHORT).show();
//        }
//    }

//    public void test(View view){
//        Toast.makeText(getApplicationContext(), "클릭하셨네요", Toast.LENGTH_SHORT).show();
//    }


}