package com.example.tanuj.intentapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class ActivityTwo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        Bundle firstData = getIntent().getExtras();

        final TextView secondText = (TextView)findViewById(R.id.secondActivity);

        if(firstData == null )
        {
           return;
        }

        String firstMessage = firstData.getString("firstMessage");

        secondText.setText(firstMessage+" from the other side");
    }


    public void onclick2(View view)
    {
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);

    }

}
