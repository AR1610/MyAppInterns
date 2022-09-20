package com.myappinterns;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtUserName;
    Button btnLogin,btnUrlView;
    TextView tvLogin;
    ImageView imgLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        edtUserName = findViewById(R.id.edt_userName);
        btnLogin = findViewById(R.id.btn_login);
        tvLogin = findViewById(R.id.tv_login);
        imgLogo = findViewById(R.id.img_data);
        btnUrlView = findViewById(R.id.btn_url_view);

        btnUrlView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Implicit Intent
                Intent i = new Intent();
                i.setAction(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://www.google.com/"));
                startActivity(i);
                // over Implicit Intent

            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strUserName = edtUserName.getText().toString().trim();
                tvLogin.setText(strUserName);
                imgLogo.setImageResource(R.drawable.ic_user);

                Toast.makeText(MainActivity.this, "Username is "+strUserName, Toast.LENGTH_SHORT).show();
                // Explicit Intent
                Intent i = new Intent(MainActivity.this,HomeActivity.class);
                i.putExtra("KEY_USERNAME",strUserName);
                startActivity(i);
                // Over Explicit Intent

            }
        });


    }
}