package com.cookandriod.taphostex;

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

        TabSpec tabSpecSong = tabHost.newTabSpec("SONG").setIndicator("음악별");
        tabSpecSong.setContent(R.id.tabSong);
        tabHost.addTab(tabSpecSong);

        TabSpec tabArtist = tabHost.newTabSpec("ARTIST").setIndicator("가수별");
        tabArtist.setContent(R.id.tabArtist);
        tabHost.addTab(tabArtist);

        TabSpec tabAlbum = tabHost.newTabSpec("ALBUM").setIndicator("앨범별");
        tabAlbum.setContent(R.id.tabAlbum);
        tabHost.addTab(tabAlbum);

        tabHost.setCurrentTab(0);

    }
}