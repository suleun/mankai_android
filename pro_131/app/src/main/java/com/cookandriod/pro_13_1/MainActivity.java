package com.cookandriod.pro_13_1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import android.os.Environment;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    ListView listViewMP3;
    Button btnPlay, btnStop;
    TextView tvMP3;
    ProgressBar pbMP3;

    String selectedMP3;
    Integer selectedSong;

    MediaPlayer mPlayer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("간단 MP3 플레이어");


        final String[] mp3List ={"song1", "song2", "song3"};
        final Integer[] songID = { R.raw.song1,R.raw.song2, R.raw.song3};


        ListView listViewMP3 = (ListView) findViewById(R.id.listViewMP3);

        //★ 입력하기,  리스트뷰에 mp3List 배열의 내용을 출력한다
        // 단, 라디오버튼의 리스트뷰를 사용한다

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, mp3List);
        listViewMP3.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listViewMP3.setAdapter(adapter);

        listViewMP3.setItemChecked(0, true);

        // 리스트뷰의 각 항목을 클릭하면 파일 이름이 selectMP3에,
        // 파일 ID가 selectSong에 저장된다
        listViewMP3
                .setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> arg0, View arg1,
                                            int arg2, long arg3) {
                        selectedMP3 = mp3List[arg2];
                        selectedSong = songID[arg2];
                    }
                });

        selectedMP3 = mp3List[0];
        selectedSong=songID[0];

        btnPlay = (Button) findViewById(R.id.btnPlay);
        btnStop = (Button) findViewById(R.id.btnStop);
        tvMP3 = (TextView) findViewById(R.id.tvMP3);
        pbMP3 = (ProgressBar) findViewById(R.id.pbMP3);


        // <듣기> 클릭시 동작하는 리스너
        btnPlay.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mPlayer = MediaPlayer.create(MainActivity.this, selectedSong);
                // ★ 입력하기, 음악이 재생, <듣기>버튼 클릭 안되고, <중지>버튼 클릭 가능설정
                mPlayer.start();
                btnPlay.setClickable(false);
                btnStop.setClickable(true);

                tvMP3.setText("실행중인 음악 :  " + selectedMP3);
                pbMP3.setVisibility(View.VISIBLE);
            }
        });

        //<중지> 클릭시 동작하는리스너
        btnStop.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // ★ 입력하기, 음악이 중지, <듣기>버튼 클릭 되고, <중지>버튼 클릭 안되도록 설정

                mPlayer.stop();
                mPlayer.reset();
                btnPlay.setClickable(true);
                btnStop.setClickable(false);


                tvMP3.setText("실행중인 음악 :  ");
                pbMP3.setVisibility(View.INVISIBLE);
            }
        });
        btnStop.setClickable(false);

    }
}
