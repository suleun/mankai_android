package com.cookandriod.mankai_page;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigation;
    LinearLayout  page;
    FloatingActionButton chatting;

    private Fragment settingFragment, groupFragment, postFragment, mypageFragment;
    private Fragment chattingFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        page = findViewById(R.id.page);
        bottomNavigation = findViewById(R.id.bottomNavigation);
        bottomNavigation.setBackground(null);

        chatting = findViewById(R.id.chatting);

        bottomNavigation.setOnNavigationItemSelectedListener(listener);

        postFragment = new PostFragment();
        groupFragment = new GroupFragment();
        mypageFragment = new MypageFragment();
        settingFragment = new SettingFragment();

        chattingFragment = new ChattingFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.page, postFragment).commit();

        chatting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.page, chattingFragment).commit();
            }

        });


    }


    private BottomNavigationView.OnNavigationItemSelectedListener listener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){
                case R.id.post:
                    getSupportFragmentManager().beginTransaction().replace(R.id.page, postFragment).commit();
                    return true;
                case R.id.group:
                    getSupportFragmentManager().beginTransaction().replace(R.id.page, groupFragment).commit();
                    return true;
                case R.id.mypage:
                    getSupportFragmentManager().beginTransaction().replace(R.id.page, mypageFragment).commit();
                    return true;
                case R.id.setting:
                    getSupportFragmentManager().beginTransaction().replace(R.id.page, settingFragment).commit();
                    return true;
            }
            return false;
        }
    };
}


