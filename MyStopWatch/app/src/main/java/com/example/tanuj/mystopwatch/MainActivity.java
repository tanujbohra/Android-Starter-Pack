package com.example.tanuj.mystopwatch;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

    private int seconds = 0;
    private boolean running;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState!=null)
        {
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
        }
        runTimer();
    }

    public void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putInt("seconds",seconds);
        savedInstanceState.putBoolean("running",running);
    }

    public void startClicked(View view){
        running = true;

    }

    public void stopClicked(View view){
        running = false;

    }

    public void resetClicked(View view){
        running = false;
        seconds = 0;
    }

    private void runTimer(){
        final TextView timeView = (TextView)findViewById(R.id.time_TextView);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds/3600;
                int minutes = (seconds%3600)/60;
                int secs = seconds%60;

                String time = String.format("%d:%02d:%02d",hours,minutes,secs);        //applying proper format

                timeView.setText(time);

                if(running){

                    seconds++;

                }
                handler.postDelayed(this,1000);

            }
        });


    }
}
