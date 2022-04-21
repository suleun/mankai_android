package com.cookandriod.mankai;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.ToggleButton;

public class InterestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interest);

    }

    public void onDefaultToggleClick(View view){
        Toast.makeText(this, "DefaultToggle", Toast.LENGTH_SHORT).show();
    }


    public void onCustomToggleClick(View view){
        Toast.makeText(this, "onCustomToggleClick", Toast.LENGTH_SHORT).show();
    }

}