package com.example.tanuj.boundser;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MyService extends Service {


    private final IBinder myBinder = new MyLocalBinder();

    public MyService() {
    }

    public class MyLocalBinder extends Binder {

        MyService getService(){
            return MyService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return myBinder;
    }

    public String getCurrentTime(){
        java.text.SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss", Locale.US);//use java.text.SimpleDateFormat for API 24 error
        return (df.format(new Date()));
    }

}
