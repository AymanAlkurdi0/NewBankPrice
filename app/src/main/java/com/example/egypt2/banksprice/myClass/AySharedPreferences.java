package com.example.egypt2.banksprice.myClass;

import android.content.SharedPreferences;

/**
 * Created by zero on 9/24/2017.
 */

public class AySharedPreferences {
    public static SharedPreferences sharedPreferences;
    public static int  mID;


   public static void save(int ID){

        SharedPreferences.Editor myEditor = sharedPreferences.edit();
        myEditor.putInt("ID",ID);
        myEditor.commit();

    }
    public static int load(){

        if (sharedPreferences.getInt("ID",-1)!=-1){
            mID = sharedPreferences.getInt("ID",0);

        }
        else{
            mID = 0;

        }
        return mID;

    }



}
