package com.example.tanuj.mysensorapp;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener{

    Sensor accelerometer;
    SensorManager sm;
    TextView acceleration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sm = (SensorManager)getSystemService(SENSOR_SERVICE);
        accelerometer = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sm.registerListener(this,accelerometer,SensorManager.SENSOR_DELAY_NORMAL);
        acceleration = (TextView) findViewById(R.id.acceleration);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        acceleration.setText("\nX:"+ sensorEvent.values[0]+
                            "\nY:"+sensorEvent.values[1]+
                            "\nZ"+sensorEvent.values[2]);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
