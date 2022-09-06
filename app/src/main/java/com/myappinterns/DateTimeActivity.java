package com.myappinterns;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class DateTimeActivity extends AppCompatActivity {

    TextView tvDate,tvTime;
    Button btnDate,btnTime;
    private int year,month,date;
    private int hours;
    private int minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time);
        tvDate = findViewById(R.id.tv_date);
        btnDate = findViewById(R.id.btn_date);

        tvTime = findViewById(R.id.tv_time);
        btnTime = findViewById(R.id.btn_time);


        Calendar calendar = Calendar.getInstance();
        year =  calendar.get(Calendar.YEAR);
        month  = calendar.get(Calendar.MONTH);
        date = calendar.get(Calendar.DATE);
        hours = calendar.get(Calendar.HOUR);
        minute = calendar.get(Calendar.MINUTE);

        btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(DateTimeActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        tvTime.setText(i+":"+i1);
                    }
                },hours,minute,true);
                timePickerDialog.show();
            }
        });


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