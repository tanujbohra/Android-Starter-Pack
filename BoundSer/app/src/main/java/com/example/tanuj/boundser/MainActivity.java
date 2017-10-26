package com.example.tanuj.boundser;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    MyService myService;
    Boolean isBound = false;

    public void onclick(View view){

                String currentTime = myService.getCurrentTime();
                TextView myText = (TextView)findViewById(R.id.myText);
                myText.setText(currentTime);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent i = new Intent(this,MyService.class);
        bindService(i,myConnection, Context.BIND_AUTO_CREATE);
    }

    private ServiceConnection myConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MyService.MyLocalBinder binder = (MyService.MyLocalBinder) iBinder; //use iBinder not service to avoid error
            myService = binder.getService();
            isBound = true;

        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

            isBound = false;

        }
    };
}
