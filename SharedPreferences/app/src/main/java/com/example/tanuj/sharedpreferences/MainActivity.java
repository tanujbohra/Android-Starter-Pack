package com.example.tanuj.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText usernameInput;
    EditText passwordInput;
    TextView myText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usernameInput = (EditText)findViewById(R.id.userNameInput);
        passwordInput = (EditText)findViewById(R.id.passwordInput);
        myText = (TextView)findViewById(R.id.myText);
    }

    //save the login info
    public void saveInfo(View view){
        SharedPreferences sharedPref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);//name of file,allow only this file to access it
        SharedPreferences.Editor editor = sharedPref.edit();//object to write to file
        //Adding stuff to file in a key-value pair
        editor.putString("username",usernameInput.getText().toString());//adding a key-value pair
        editor.putString("password",passwordInput.getText().toString());//adding a key-value pair
        editor.apply();
        Toast.makeText(this,"Saved",Toast.LENGTH_LONG).show();//letting user know it is saved
    }

    //displaying the data of shared preference file

    public void displayData(View view){
        //reference the shared preference file and setting which apps are allowed to access it
        SharedPreferences sharedPref = getSharedPreferences("userInfo",Context.MODE_PRIVATE);
        String name = sharedPref.getString("username","");//blank input is used when the refered string is not present
        String pw = sharedPref.getString("password","");
        myText.setText(name+" "+pw);


    }
}


















