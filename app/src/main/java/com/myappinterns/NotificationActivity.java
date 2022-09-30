package com.myappinterns;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NotificationActivity extends AppCompatActivity {
    Button btnNotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        btnNotification = findViewById(R.id.btn_notification);
        btnNotification.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {

                Intent i = new Intent(NotificationActivity.this,CustomListViewActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(NotificationActivity.this,
                        1,i,PendingIntent.FLAG_ONE_SHOT);

                NotificationChannel notificationChannel = new NotificationChannel("com.myappinterns",
                        "Channel_name", NotificationManager.IMPORTANCE_HIGH);

                NotificationCompat.Builder builder = new NotificationCompat.Builder(NotificationActivity.this);
                builder.setSmallIcon(R.drawable.home);
                builder.setContentTitle(getResources().getString(R.string.app_name));
                builder.setContentText("No Lecture Today");
                builder.setChannelId("com.myappinterns");
                builder.setContentIntent(pendingIntent);

                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager.createNotificationChannel(notificationChannel);
                notificationManager.notify(1, builder.build());


            }
        });
    }
}