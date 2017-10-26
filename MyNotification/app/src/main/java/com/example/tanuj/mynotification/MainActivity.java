package com.example.tanuj.mynotification;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    NotificationCompat.Builder notification;
    private static final int uniqueId= 420183;//for system to keep track of notification

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notification = new NotificationCompat.Builder(this);
        notification.setAutoCancel(true);//to remove notification when app is opened

    }

    //Build the notification
    public void myButtonClicked(View view){
        //describing our intent
        notification.setSmallIcon(R.mipmap.ic_launcher);
        notification.setTicker("This is the ticker");
        notification.setWhen(System.currentTimeMillis());
        notification.setContentTitle("This is the Title");
        notification.setContentText("This is the description or the body of the Notification");


        //where to go when clicked
        Intent intent = new Intent(this,MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(pendingIntent);


        //Build our intent and send it

        NotificationManager nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        nm.notify(uniqueId,notification.build());
    }
}
