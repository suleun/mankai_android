package com.cookandriod.tabhost6_3;

import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

@SuppressWarnings("deprecation")
public class MainActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost tabHost = getTabHost();

        TabSpec tabSpecat = tabHost.newTabSpec("cat").setIndicator("고양이");
        tabSpecat.setContent(R.id.cat);
        tabHost.addTab(tabSpecat);

        TabSpec tabSpedog = tabHost.newTabSpec("dog").setIndicator("개");
        tabSpedog.setContent(R.id.dog);
        tabHost.addTab(tabSpedog);

        TabSpec tabSpechorse = tabHost.newTabSpec("horse").setIndicator("말");
        tabSpechorse.setContent(R.id.horse);
        tabHost.addTab(tabSpechorse);


        TabSpec tabSpecrabbit = tabHost.newTabSpec("rabbit").setIndicator("토끼");
        tabSpecrabbit.setContent(R.id.rabbit);
        tabHost.addTab(tabSpecrabbit);

        tabHost.setCurrentTab(0);
    }
}