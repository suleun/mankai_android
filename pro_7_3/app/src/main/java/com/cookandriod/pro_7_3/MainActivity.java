package com.cookandriod.pro_7_3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvname, tvemail;
    Button btn;
    EditText edname, edemail;
    TextView toastTv;
    View dialogView, toastView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("커스텀 대화상자");

        tvname = findViewById(R.id.tvname);
        tvemail = findViewById(R.id.tvemail);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogView = View.inflate(MainActivity.this, R.layout.dialog, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("사용자 정보 입력");
                dlg.setIcon(R.drawable.ic_launcher_background);

//                edname.setText(tvname.getText().toString());
//                edemail.setText(tvemail.getText().toString());

                dlg.setView(dialogView);
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        edname = dialogView.findViewById(R.id.edname);
                        edemail = dialogView.findViewById(R.id.edemail);

                        tvname.setText(edname.getText().toString());
                        tvemail.setText(edemail.getText().toString());
                    }
                });
                dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast toast = new Toast(MainActivity.this);
                        toastView = View.inflate(MainActivity.this, R.layout.toast, null);
                        toastTv = toastView.findViewById(R.id.toastTv);
                        toastTv.setText("취소했습니다.");
                        toast.setView(toastView);
                        toast.show();

                    }
                });
                dlg.show();
            }
        });


    }
}