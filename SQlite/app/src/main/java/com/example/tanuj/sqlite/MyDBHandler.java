package com.example.tanuj.sqlite;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBHandler extends SQLiteOpenHelper {

    //naming database,table,column names

    private static final int DATABASE_VERSION = 1;//update version when you add new columns
    private static final String DATABASE_NAME="products.db";

    public static final String TABLE_PRODUCTS="products";
    public static final String COLUMN_ID="_id";
    public static final String COLUMN_PRODUCTNAME="productname";

    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }


    //create a table and add constraints
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = " CREATE TABLE "+TABLE_PRODUCTS+"("+
                COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                COLUMN_PRODUCTNAME+" TEXT "+
                ");";
        db.execSQL(query);

    }
    //on upgrade delete the earlier table and create new
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_PRODUCTS);
        onCreate(db);
    }

    public void addProduct(Products product){
        ContentValues values = new ContentValues();
        values.put(COLUMN_PRODUCTNAME,product.get_productname());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_PRODUCTS,null,values);
        db.close();
    }

    public void deleteProduct(String _productname){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM "+TABLE_PRODUCTS+" WHERE "+COLUMN_PRODUCTNAME+" =\"" +_productname+ "\";" );
    }


    //print out database as a String
    public String databaseToString(){
        String dbString ="";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM "+TABLE_PRODUCTS;

        //Cursor is going to print to a location in your results
        Cursor c = db.rawQuery(query,null);
        //move to the first row
        c.moveToFirst();
        while (!c.isAfterLast()) {
            if(c.getString(c.getColumnIndex("productname"))!=null){
                dbString+=c.getString(c.getColumnIndex("productname"));
                dbString+="\n";
            }
            c.moveToNext();
        }
        db.close();
        return dbString;
    }


}




