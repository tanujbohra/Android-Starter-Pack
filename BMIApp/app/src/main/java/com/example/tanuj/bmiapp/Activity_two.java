package com.example.tanuj.bmiapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Activity_two extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void calculateBmiClicked(View view)
    {
        //Getting reference to all views that are required
        EditText inputWeight = (EditText) findViewById(R.id.inputWeight_EditText);
        EditText inputHeight = (EditText) findViewById(R.id.inputHeight_EditText);
        TextView yourBmi = (TextView) findViewById(R.id.yourBMI_TextView);
        TextView result = (TextView) findViewById(R.id.result_TextView);
        Button calculateBmi = (Button) findViewById(R.id.calculateBMI_Button);
        //Initializing variables for calculation

        double height = 0;
        double weight = 0;
        double bmi = 0;
        String message = "";

        weight = Double.parseDouble(inputWeight.getText().toString());
        height = Double.parseDouble(inputHeight.getText().toString());

        bmi = height*height;
        bmi=weight/bmi;
        yourBmi.setText(String.valueOf(bmi));

        if(bmi<18.5)
        {
            message ="Under Weight";
        }
        else if (bmi>18.5 && bmi<25)
        {
            message ="Normal";
        }
        else if(bmi>25)
        {
            message="Over Weight";
        }

        result.setText(message);


    }

}
