package com.example.tanuj.intentapplication;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;


public class MyIntentService extends IntentService {

    private static final String TAG="com.example.tanuj.intentapplication";

    public MyIntentService() {
        super("MyIntentService");

    }

    @Override
    protected void onHandleIntent(Intent intent){
        Log.i(TAG,"The service has started");

    }

}




