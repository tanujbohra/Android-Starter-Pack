package com.example.tanuj.sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //getting references
    EditText myInput;
    TextView myText;
    MyDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myInput = (EditText)findViewById(R.id.myInput);
        myText = (TextView)findViewById(R.id.myText);

        dbHandler = new MyDBHandler(this,null,null,1);
        printDatabase();
    }

    //printing database

    public void printDatabase(){
        String dbString = dbHandler.databaseToString();
        myText.setText(dbString);
        myInput.setText("");
    }

    //Add a product to Database

    public void addButtonClicked(View view){
        Products product = new Products(myInput.getText().toString());
        dbHandler.addProduct(product);
        printDatabase();
    }

    //Delete Items

    public void deleteButtonClicked(View view){
        String inputText = myInput.getText().toString();
        dbHandler.deleteProduct(inputText);
        printDatabase();
    }
}
