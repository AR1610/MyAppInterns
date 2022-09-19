package com.myappinterns;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TypesofMenuActivity extends AppCompatActivity {

    TextView tvClickMe;
    private Button btnPopUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_typesof_menu);
        tvClickMe = findViewById(R.id.tv_clickme);
        registerForContextMenu(tvClickMe);
        btnPopUp = (Button)findViewById(R.id.btn_popup);
        btnPopUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PopupMenu popupMenu = new PopupMenu(TypesofMenuActivity.this,btnPopUp);
                MenuInflater menuInflater = getMenuInflater();
                menuInflater.inflate(R.menu.item_menu,popupMenu.getMenu());
                popupMenu.show();

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(TypesofMenuActivity.this, "Item is"+item.getTitle(), Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });

            }
        });



    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.item_menu,menu);

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        int item_id = item.getItemId();
        if (item_id == R.id.item_add){

        }else if (item_id == R.id.item_settings){
            Intent i = new Intent(TypesofMenuActivity.this,CustomGridViewActivity.class);
            startActivity(i);
        }

        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.item_menu,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int item_id = item.getItemId();
     if (item_id == R.id.item_add){

     }else if (item_id == R.id.item_settings){
         Intent i = new Intent(TypesofMenuActivity.this,CustomGridViewActivity.class);
         startActivity(i);
     }

        return super.onOptionsItemSelected(item);
    }
}