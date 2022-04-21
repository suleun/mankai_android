package com.cookandriod.gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cookandriod.gridview.R;

import org.w3c.dom.Text;

public class InterestAdapter extends BaseAdapter {

    Context context;
    LayoutInflater inflater;
    String[] arrName;
    int[] arrImage;

    public InterestAdapter(Context context, String[] arrName, int[] arrImage ){
        this.context = context;
        this.arrName = arrName;
        this.arrImage = arrImage;
    }

    @Override
    public int getCount() {
        return arrName.length;
    }

    @Override
    public Object getItem(int i) {
        return arrName[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (inflater == null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        if (view==null){
            view = inflater.inflate(R.layout.interest_layout, null);
        }

        ImageView interestImage = view.findViewById(R.id.imgView);
        TextView textView = view.findViewById(R.id.tvName);

        interestImage.setImageResource(arrImage[i]);
        textView.setText(arrName[i]);


        return view;
    }
}
