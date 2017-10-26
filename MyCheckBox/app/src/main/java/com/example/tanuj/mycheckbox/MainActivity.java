package com.example.tanuj.mycheckbox;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClicked(View view){
        TextView myText = (TextView)findViewById(R.id.myText);
        boolean checked = ((CheckBox)view).isChecked();
        /*CheckBox tea = (CheckBox)findViewById(R.id.tea);
        CheckBox milk = (CheckBox)findViewById(R.id.milk);
        boolean teachecked = tea.isChecked();
        boolean milkchecked = milk.isChecked();

        //Toast.makeText(MainActivity.this,test,Toast.LENGTH_LONG).show();
        if( teachecked == true && milkchecked == true)
            myText.setText("Milk and Tea both are added");
        else if(teachecked == false && milkchecked == false)
            myText.setText("Nothing is added");
        else{
            if(teachecked == true)
                myText.setText("tea is checked");
            else if (milkchecked == true)
                myText.setText("milk is checked");
        }*/

        switch (view.getId()){
            case R.id.tea:
                if(checked)
                    myText.setText("Tea");
                break;
            case R.id.milk:
                if(checked)
                    myText.setText("milk");
                break;

        }
    }
}
