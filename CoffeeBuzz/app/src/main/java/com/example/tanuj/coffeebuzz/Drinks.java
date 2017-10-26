package com.example.tanuj.coffeebuzz;


public class Drinks {
    //initializing the variables
    private String name;
    private String desc;
    private int imageID;
    //array f objects
    public static final Drinks[] drinks = {
            new Drinks("Latte","this is the description for latte",R.drawable.coffee),
            new Drinks("cappuccino","this is the description for cappuccino",R.drawable.coffee),
            new Drinks("Masala Tea","this is the description for masala tea",R.drawable.coffee)

    };

    //constructor
    private Drinks(String name,String desc,int imageID){
        this.name=name;
        this.desc=desc;
        this.imageID=imageID;
    }

    public String getDesc(){
        return desc;
    }

    public int getImageID(){
        return imageID;
    }
    public  String getName(){
        return name;
    }

    public  String toString(){
        return this.name;
    }
}
