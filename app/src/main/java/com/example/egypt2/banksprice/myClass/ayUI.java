package com.example.egypt2.banksprice.myClass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.egypt2.banksprice.R;

import java.util.ArrayList;

/**
 * Created by egypt2 on 8/27/2017.
 */

public class ayUI {
    public static ArrayList<ayINFO> fArrayList ;
    public static String LastApdate;
    public static Context context;
    static ListView ayListView;
    static TextView ayLastUpdate;




    public static void  update(){

        //conect with the layput todo:make sure that works
         /*
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View view = layoutInflater.inflate(R.layout.activity_main,null);
        */

        //Notification
        AyNotification ayNotification = new AyNotification();
        ayNotification.notify(context,"Up to date",123);
        //create and set the adapter


        ayAdapter myayAdapter =new ayAdapter(getContext(),fArrayList);
        ayListView.setAdapter(myayAdapter);
        ayLastUpdate.setText("Update : " +LastApdate);

    }





























    public static void setfArrayList(ArrayList<ayINFO> fArrayList) {
        ayUI.fArrayList = fArrayList;
    }

    public static void setLastApdate(String lastApdate) {
        LastApdate = lastApdate;
    }

    public static void setContext(Context context) {
        ayUI.context = context;
    }

    public static ArrayList<ayINFO> getfArrayList() {
        return fArrayList;
    }

    public static String getLastApdate() {
        return LastApdate;
    }

    public static Context getContext() {
        return context;
    }


    public static void setAyListView(ListView ayListView) {
        ayUI.ayListView = ayListView;
    }

    public static void setAyLastUpdate(TextView ayLastUpdate) {
        ayUI.ayLastUpdate = ayLastUpdate;
    }

    public static ListView getAyListView() {

        return ayListView;
    }

    public static TextView getAyLastUpdate() {
        return ayLastUpdate;
    }
}
