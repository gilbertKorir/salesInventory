package com.example.shopsales;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "Shopsales.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "mysales";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "product_name";
    private static final String COLUMN_CODE = "product_code";
    private static final String COLUMN_PRICE = "product_price";

    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + "("+ COLUMN_ID +" INTEGER PRIMARY KEY AUTOINCREMENT, "
                                       + COLUMN_NAME +" TEXT, " +
                                         COLUMN_CODE + " TEXT, " +
                                         COLUMN_PRICE + " INTEGER )";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    //user defined methods
    void addProduct(String product_name, String code, int price){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_NAME, product_name);
        cv.put(COLUMN_CODE, code);
        cv.put(COLUMN_PRICE, price);

        long result = db.insert(TABLE_NAME, null, cv);
        if(result == -1){
            Toast.makeText(context, "Failed to Add.", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Added Successfully", Toast.LENGTH_SHORT).show();
        }
    }
}
