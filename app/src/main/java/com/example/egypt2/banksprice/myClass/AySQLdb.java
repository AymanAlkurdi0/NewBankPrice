package com.example.egypt2.banksprice.myClass;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by zero on 9/29/2017.
 */

public class AySQLdb extends SQLiteOpenHelper {
    public static boolean Iscreated ;
    public static final String DB_NAME = "ayinfo";
    public static final int VERSION_NUMBER = 1;


    public AySQLdb(Context context) {
        super(context, DB_NAME, null, VERSION_NUMBER);
    }

    //*************************************************************************************************************************
    //create section
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table IF NOT EXISTS INFO (id INTEGER primary key ,bank_ID INTEGER ,bank_Name TEXT ,currency_ID INTEGER ,currency_Name TEXT ,currency_code TEXT ,buy TEXT ,sell TEXT ,LastUpdata TEXT ,type INTEGER)");

    }

    //*************************************************************************************************************************
    //upgrade section
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if EXISTS INFO");
        onCreate(db);

    }

    //*************************************************************************************************************************
    //wirte section
    public void InsertData(ayINFO NewINFO) {
        //set the data base WritableDatabase to write on it
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        //create ContentValues to put the item on it
        ContentValues contentValues = new ContentValues();

        contentValues.put("bank_ID", NewINFO.getBank_ID());
        contentValues.put("bank_Name", NewINFO.getBank_Name());
        contentValues.put("currency_ID", NewINFO.getCurrency_ID());
        contentValues.put("currency_Name", NewINFO.getCurrency_Name());
        contentValues.put("currency_code", NewINFO.getCurrency_code());
        contentValues.put("buy", NewINFO.getBuy());
        contentValues.put("sell", NewINFO.getSell());
        contentValues.put("LastUpdata", NewINFO.getLastUpdata());
        contentValues.put("type", NewINFO.getType());
        //add new node(culleom)
        sqLiteDatabase.insert("INFO", null, contentValues);


    }

    public void InsertArray(ArrayList<ayINFO> arrayList) {
        //to delete the database and create new one
        onUpgrade(this.getWritableDatabase(),1,2);
        //passing the item in arraylist to InsertData() method
        for (int n = 0; n < arrayList.size(); n++) {
            InsertData(arrayList.get(n));
        }


    }

    //*************************************************************************************************************************
    //read section
    ArrayList<ayINFO> arrayList;

    public ArrayList<ayINFO> GetData() {
        //creaete a array list to put on it
        arrayList = new ArrayList<ayINFO>();
        //node to add each one
        ayINFO myinfo;
        //ReadableDatabase to read from data base
        SQLiteDatabase db = this.getReadableDatabase();
        //cursor to fetch the data
        Cursor res = db.rawQuery("SELECT  * FROM INFO", null);
        //set in the first
        res.moveToFirst();
        //loading all the item
        while (res.isAfterLast() == false) {
            myinfo = new ayINFO();
            myinfo.setType(res.getInt(res.getColumnIndex("type")));
            myinfo.setBank_ID(res.getInt(res.getColumnIndex("bank_ID")));
            myinfo.setBank_Name(res.getString(res.getColumnIndex("bank_Name")));
            myinfo.setCurrency_ID(res.getInt(res.getColumnIndex("currency_ID")));
            myinfo.setCurrency_Name(res.getString(res.getColumnIndex("currency_Name")));
            myinfo.setCurrency_code(res.getString(res.getColumnIndex("currency_code")));
            myinfo.setBuy(res.getString(res.getColumnIndex("buy")));
            myinfo.setSell(res.getString(res.getColumnIndex("sell")));
            myinfo.setLastUpdata(res.getString(res.getColumnIndex("LastUpdata")));

            arrayList.add(myinfo);

            res.moveToNext();
        }
        //close
        res.close();
        //return the data as Array list
        return arrayList;

    }


}
