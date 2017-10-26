package com.example.tanuj.mynewapp;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.content.res.Resources;
import android.util.TypedValue;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RelativeLayout myLayout=new RelativeLayout(this);//creating layout object
        Button myButton=new Button(this);//creating button object
        myLayout.setBackgroundColor(Color.BLUE);
        myButton.setBackgroundColor(Color.GREEN);
        myButton.setText("Click here");

        RelativeLayout.LayoutParams buttonDetails =  //creating on=bject that accepts parameters
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT
                );
        buttonDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);//adding rules
        buttonDetails.addRule(RelativeLayout.CENTER_VERTICAL);

        myLayout.addView(myButton,buttonDetails);//adding created view to layout

        EditText username = new EditText(this);

        username.setId(2);
        myButton.setId(1);
        RelativeLayout.LayoutParams usernameDetails =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT
                );

        usernameDetails.addRule(RelativeLayout.ABOVE,myButton.getId());
        usernameDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);

        Resources r = getResources();//get Resources associated with device
        int px = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,200,r.getDisplayMetrics());
        username.setWidth(px);

        usernameDetails.setMargins(0,0,0,50);
        myLayout.addView(username,usernameDetails);
        setContentView(myLayout);//setting layout

    }
}
