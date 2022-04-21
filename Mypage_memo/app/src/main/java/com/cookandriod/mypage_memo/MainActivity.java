package com.cookandriod.mypage_memo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RecyclerView recycleView;

    String s1[];

    Button sns_btn, board_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycleView = findViewById(R.id.recycleView);

        s1 = getResources().getStringArray(R.array.title);



        MyAdapter myAdapter = new MyAdapter(this, s1);
        recycleView.setAdapter(myAdapter);
        recycleView.setLayoutManager(new LinearLayoutManager(this));

    }

    public void custom_dialog(View v) {
        View dialogView = getLayoutInflater().inflate(R.layout.custom_dialog, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
        builder.setView(dialogView);

        final AlertDialog alertDialog = builder.create();
        alertDialog.show();

        sns_btn = dialogView.findViewById(R.id.sns_btn);
        board_btn = dialogView.findViewById(R.id.board_btn);

        sns_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // intent
                Intent intent = new Intent(MainActivity.this, SnsPost.class);
                startActivity(intent);

                alertDialog.dismiss();
            }
        });

        board_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //intent
                Intent intent = new Intent(MainActivity.this, BoardPost.class);
                startActivity(intent);

                alertDialog.dismiss();
            }
        });

    }
}