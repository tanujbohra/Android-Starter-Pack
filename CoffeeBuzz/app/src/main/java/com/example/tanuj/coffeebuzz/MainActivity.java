package com.example.tanuj.coffeebuzz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Adapter for ListView
        AdapterView.OnItemClickListener itemClickListener =
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                        if(position==0){
                            Intent intent = new Intent(MainActivity.this,DrinkCategoryActivity.class);
                            startActivity(intent);
                        }

                    }
                };
        ListView  listView = (ListView) findViewById(R.id.options_List);
        listView.setOnItemClickListener(itemClickListener);
    }
}
