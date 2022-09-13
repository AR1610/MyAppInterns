package com.myappinterns;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyGridAdapter extends BaseAdapter {


    Context context;
    ArrayList<Bean> beanArrayList;


    public MyGridAdapter(Context context, ArrayList<Bean> beanArrayList) {

        this.context = context;
        this.beanArrayList = beanArrayList;
    }

    @Override
    public int getCount() {
        return beanArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return beanArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = layoutInflater.inflate(R.layout.raw_custom_grid,null);
        ImageView imgData = view.findViewById(R.id.img_data);
        TextView tvData = view.findViewById(R.id.tv_data);

        imgData.setImageResource(beanArrayList.get(i).getImgLang());
        tvData.setText(beanArrayList.get(i).getStrLang());

        return view;
    }
}
