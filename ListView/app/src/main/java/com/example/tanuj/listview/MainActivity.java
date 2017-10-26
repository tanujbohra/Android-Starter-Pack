package com.example.tanuj.listview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] fruits = {"Apple", "Orange", "Mango", "Peach"};

        //Adapter to convert string to listview
        ListAdapter myAdapter = new CustomAdapter(this,fruits);

        ListView myListView = (ListView) findViewById(R.id.MyListView);
        myListView.setAdapter(myAdapter);

        myListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        String fruit = String.valueOf(adapterView.getItemAtPosition(i));
                        //adapterview instead of parent and i instead of position
                        Toast.makeText(MainActivity.this,fruit,Toast.LENGTH_LONG).show();
                    }
                }
        );





    }
}
