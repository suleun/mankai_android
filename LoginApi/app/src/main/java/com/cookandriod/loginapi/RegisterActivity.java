package com.cookandriod.loginapi;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    EditText etName, etEmail, etPassword, etConfirmation;
    Button btnRegister;
    String name, email, password, confirmation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etConfirmation = findViewById(R.id.etConfirmation);
        btnRegister = findViewById(R.id.btnRegister);
        
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkRegister();
            }
        });
                

    }

    private void checkRegister() {
        name = etName.getText().toString();
        email = etEmail.getText().toString();
        password = etPassword.getText().toString();
        confirmation = etConfirmation.getText().toString();
        
        if (name.isEmpty() || email.isEmpty() || password.isEmpty()){
            alertFail("Name, Email and Password id required.");
        }else if (! password.equals(confirmation)){
            alertFail("Password and Password Confirmation doesn't match");
        }else{
            sendRegister();
        }
    }

    private void sendRegister() {
        alertSuccess("Register is succesfuly");
    }

    private void alertSuccess(String s) {
        new AlertDialog.Builder(this)
                .setTitle("Success")
                .setIcon(R.drawable.ic_baseline_check_box_24)
                .setMessage(s)
                .setPositiveButton("Login", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        onBackPressed();
                    }
                }).show();
    }


    private void alertFail(String s) {
        new AlertDialog.Builder(this)
                .setTitle("Failed")
                .setIcon(R.drawable.ic_baseline_report_problem_24)
                .setMessage(s)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }).show();
    }
}