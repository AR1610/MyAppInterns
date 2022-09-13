package com.myappinterns;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class CustomListViewActivity extends AppCompatActivity {

    ListView listView;
    String strLang[] = {"Android", "Java", "PHP", "C", "C++", "IOS", "Python"};
    int imgLang[] = {R.mipmap.ic_launcher_round, R.drawable.ic_java, R.drawable.ic_php,
            R.drawable.ic_c, R.drawable.ic_cc, R.drawable.ic_ios, R.drawable.ic_python};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_view);
        listView = findViewById(R.id.list_view);
        ArrayList<Bean> beanArrayList = new ArrayList<Bean>();
        for (int i = 0; i < strLang.length; i++) {
            Bean bean = new Bean(strLang[i], imgLang[i]);
            beanArrayList.add(bean);
        }

        MyBaseAdapter myBaseAdapter = new MyBaseAdapter(this,beanArrayList);
        listView.setAdapter(myBaseAdapter);

    }
}