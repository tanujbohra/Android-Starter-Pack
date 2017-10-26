package com.example.tanuj.event_demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener{

    private TextView myMessage;
    private GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myMessage=(TextView)findViewById(R.id.myMessage);
        this.gestureDetector = new GestureDetector(this,this);
        gestureDetector.setOnDoubleTapListener(this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        myMessage.setText("SingleTapConfirmed");
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent motionEvent) {
        myMessage.setText("DoubleTap");
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        myMessage.setText("onDoubleTapEvent");
        return false;
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        myMessage.setText("onDown");
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {
        myMessage.setText("onShowPress");

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        myMessage.setText("onSingleTapUp");
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        myMessage.setText("onScroll");
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {
        myMessage.setText("onLongPress");

    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        myMessage.setText("onFling");
        return false;
    }
}
