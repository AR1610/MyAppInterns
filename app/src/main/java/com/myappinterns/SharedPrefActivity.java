package com.myappinterns;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SharedPrefActivity extends AppCompatActivity {

    EditText edtFn, edtLn;
    Button btnSave, btnDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_pref);
        edtFn = findViewById(R.id.edt_fn);
        edtLn = findViewById(R.id.edt_ln);
        btnSave = findViewById(R.id.btn_save);
        btnDisplay = findViewById(R.id.btn_display);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strFn = edtFn.getText().toString();
                String strLn = edtLn.getText().toString();

                SharedPreferences sharedPreferences = getSharedPreferences("MYAPP", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("SHARED_FN", strFn);
                editor.putString("SHARED_LN", strLn);
                editor.commit();

                edtFn.setText("");
                edtLn.setText("");
            }
        });


        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                SharedPreferences sharedPreferences = getSharedPreferences("MYAPP", MODE_PRIVATE);
                String fn = sharedPreferences.getString("SHARED_FN", "");
                String ln = sharedPreferences.getString("SHARED_LN", "");
                edtFn.setText(fn);
                edtLn.setText(ln);

            }
        });

    }
}