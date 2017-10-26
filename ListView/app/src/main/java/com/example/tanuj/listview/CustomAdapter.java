package com.example.tanuj.listview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class CustomAdapter extends ArrayAdapter {
    public CustomAdapter( Context context,  String [] fruits) {
        super(context,R.layout.custom_row , fruits);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //Initialize our layout
        LayoutInflater myInflator = LayoutInflater.from(getContext());
        View CustomView = myInflator.inflate(R.layout.custom_row,parent,false);

        //getting reference to three things

        String singlefruititem = String.valueOf(getItem(position));  //convert object to string

        TextView myText = (TextView)CustomView.findViewById(R.id.myTextView);
        ImageView myImage = (ImageView)CustomView.findViewById(R.id.myImageView);

        myText.setText(singlefruititem);
        myImage.setImageResource(R.drawable.mango);

        return CustomView;

    }
}
