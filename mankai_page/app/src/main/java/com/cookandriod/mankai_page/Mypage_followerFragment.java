package com.cookandriod.mankai_page;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class Mypage_followerFragment extends Fragment {


    public Mypage_followerFragment() {
        // Required empty public constructor
        System.out.println("Mypage_follerFragment created!!!!!!!!!!!!!!");
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        System.out.println("R.layout.fragment_mypage_follower:" + R.layout.fragment_mypage_follower);
        System.out.println("container:" + container);
        return inflater.inflate(R.layout.fragment_mypage_follower, container, false);
    }


}