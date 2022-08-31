package com.myappinterns;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;

public class SeekbarActivity extends AppCompatActivity {

    SeekBar seekBar;
    TextView tvSeekbar,tvRatingbar;
RatingBar ratingBar;
String strSeekbar,strRatingBar;
Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seekbar);
        seekBar = findViewById(R.id.seekbar);
        tvSeekbar = findViewById(R.id.tv_seekbar);
        ratingBar = findViewById(R.id.rating_bar);
        tvRatingbar = findViewById(R.id.tv_ratingbar);
        btnNext = findViewById(R.id.btn_next);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {

                tvRatingbar.setText(String.valueOf(v));
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {

                strSeekbar = String.valueOf(progress);
                tvSeekbar.setText(strSeekbar);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String rating = tvRatingbar.getText().toString();
                Intent i = new Intent(SeekbarActivity.this,HomeActivity.class);
                i.putExtra("KEY_SEEKBAR",strSeekbar);
                i.putExtra("KEY_RATING",rating);
                startActivity(i);

            }
        });
    }
}