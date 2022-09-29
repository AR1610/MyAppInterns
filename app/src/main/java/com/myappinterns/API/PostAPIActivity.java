package com.myappinterns.API;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.myappinterns.R;

import java.util.HashMap;
import java.util.Map;

public class PostAPIActivity extends AppCompatActivity {
    EditText edtFn, edtLn,edtEmail,edtPass;
    Button btnSave, btnDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_apiactivity);
        edtFn = findViewById(R.id.edt_fn);
        edtLn = findViewById(R.id.edt_ln);
        edtEmail = findViewById(R.id.edt_email);
        edtPass = findViewById(R.id.edt_password);

        btnSave = findViewById(R.id.btn_save);
        btnDisplay = findViewById(R.id.btn_display);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strFn = edtFn.getText().toString();
                String strLn = edtLn.getText().toString();
                String strEmail = edtEmail.getText().toString();
                String strPass = edtPass.getText().toString();

                postAPILoad(strFn,strLn,strEmail,strPass);
            }
        });



    }

    private void postAPILoad(String strFn, String strLn, String strEmail, String strPass) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Utils.MAIN_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.e("TAG", "onResponse: "+response );

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map = new HashMap<String, String>();
                map.put("first_name",strFn);
                map.put("last_name",strLn);
                map.put("email",strEmail);
                map.put("password",strPass);
                return map;
            }
        };


        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);
    }

    public void display(View view) {
        Intent i = new Intent(PostAPIActivity.this,GetAPIActivity.class);
        startActivity(i);
    }
}