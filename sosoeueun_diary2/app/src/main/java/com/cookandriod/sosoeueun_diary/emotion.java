package com.cookandriod.sosoeueun_diary;

import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;

public class emotion extends Fragment {

    public emotion() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_emotion, container, false);

        final ArrayList<String> midList = new ArrayList<String>();
        ListView list = (ListView) view.findViewById(R.id.listView);

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, midList);
        list.setAdapter(adapter);

        final EditText edtItem = (EditText) view.findViewById(R.id.inputToDo);
        Button btnAdd = (Button) view.findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                midList.add(edtItem.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });

        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {

                midList.remove(position);
                adapter.notifyDataSetChanged();

                return false;
            }
        });

        return view;

    }
}