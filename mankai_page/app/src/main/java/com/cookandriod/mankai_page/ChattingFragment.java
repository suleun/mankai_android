package com.cookandriod.mankai_page;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.cookandriod.mankai_page.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class ChattingFragment extends Fragment {

    public ChattingFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.fragment_chatting, container, false);

        return view;


    }
}