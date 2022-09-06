package com.myappinterns;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class DateTimeActivity extends AppCompatActivity {

    TextView tvDate;
    Button btnDate;
    private int year,month,date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time);
        tvDate = findViewById(R.id.tv_date);
        btnDate = findViewById(R.id.btn_date);

        Calendar calendar = Calendar.getInstance();
        year =  calendar.get(Calendar.YEAR);
        month  = calendar.get(Calendar.MONTH);
        date = calendar.get(Calendar.DATE);


        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(DateTimeActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayofMonth) {

                        tvDate.setText(dayofMonth+"/"+(month+1)+"/"+year);
                    }
                },year,month,date);
                datePickerDialog.show();

            }
        });


    }
}