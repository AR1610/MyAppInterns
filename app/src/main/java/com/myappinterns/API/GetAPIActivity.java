package com.myappinterns.API;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.myappinterns.Bean;
import com.myappinterns.MyBaseAdapter;
import com.myappinterns.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class GetAPIActivity extends AppCompatActivity {
ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_apiactivity);
        listView = findViewById(R.id.list_view);

        getAPIData();
    }

    private void getAPIData() {
        ArrayList<Bean> beanArrayList = new ArrayList<Bean>();
        StringRequest stringRequest = new StringRequest(Request.Method.GET, Utils.MAIN_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONArray jsonArray = new JSONArray(response);
                    for (int i = 0; i< jsonArray.length(); i++){

                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String strfn = jsonObject.getString("first_name");
                        String strln = jsonObject.getString("last_name");
                        String name = strfn+" "+strln;
                        Bean bean = new Bean();
                        bean.setStrLang(name);
                        beanArrayList.add(bean);
                    }

                    GetBaseAdapter myBaseAdapter = new GetBaseAdapter(GetAPIActivity.this,beanArrayList);
                    listView.setAdapter(myBaseAdapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);
    }
}