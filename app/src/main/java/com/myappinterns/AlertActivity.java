package com.myappinterns;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AlertActivity extends AppCompatActivity {
    Button btnAlertDialog,btnCustomDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert);
        btnAlertDialog = findViewById(R.id.btn_alertDialog);
        btnCustomDialog = findViewById(R.id.btn_cstm_dialog);

        btnCustomDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LayoutInflater layoutInflater = getLayoutInflater();
                View my_view = layoutInflater.inflate(R.layout.raw_dialog,null);
                AlertDialog.Builder builder = new AlertDialog.Builder(AlertActivity.this);
                AlertDialog alertDialog = builder.create();
                alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                alertDialog.setView(my_view);
                alertDialog.show();

                Button btnContinue = my_view.findViewById(R.id.btn_continue);
                btnContinue.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (alertDialog.isShowing()){
                            alertDialog.dismiss();
                        }
                        Intent i = new Intent(AlertActivity.this,SeekbarActivity.class);
                        startActivity(i);
                    }
                });



            }
        });


        btnAlertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(AlertActivity.this);
                builder.setIcon(R.drawable.home);
                builder.setTitle(R.string.app_name);
                builder.setMessage("Are you sure, you want to delete this file ?");
                builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(AlertActivity.this, "Delete is clicked", Toast.LENGTH_SHORT).show();
                    }
                }).setPositiveButtonIcon(getResources().getDrawable(R.drawable.ic_baseline_delete_forever_24)).create();
                builder.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Toast.makeText(AlertActivity.this, "No is clicked", Toast.LENGTH_SHORT).show();

                    }
                });
                builder.setNeutralButton("Finish", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        dialogInterface.dismiss();
                    }
                });
                builder.show();

            }
        });
    }
}