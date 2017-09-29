package com.example.egypt2.banksprice.myClass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.egypt2.banksprice.R;

import java.util.ArrayList;
import java.util.Collections;

import jp.co.recruit_lifestyle.android.widget.WaveSwipeRefreshLayout;

/**
 * Created by egypt2 on 8/27/2017.
 */

public class ayUI {
    public static AySQLdb aySQLdb;
    public static WaveSwipeRefreshLayout mWaveSwipeRefreshLayout;
    public static ArrayList<ayINFO> fArrayList ;
    public static String LastApdate;
    public static Context context;
    static ListView ayListView;
    static TextView ayLastUpdate;
    static ayAdapter myayAdapter;



    public static void  update(){

        //conect with the layput todo:make sure that works
         /*
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View view = layoutInflater.inflate(R.layout.activity_main,null);
        */

        //Notification //todo:Notification turn on
      //  AyNotification ayNotification = new AyNotification();
       // ayNotification.notify(context,"Up to date",123);


        //create and set the adapter
        myayAdapter =new ayAdapter(getContext(),fArrayList);
        ayListView.setAdapter(myayAdapter);
        ayLastUpdate.setText("Update : " +  getLastApdate());

//**************************************************************************





    }
//function for sort the item in list view todo: Edite this function to make it call pop activity for selecte more then one style sorting
    public static  void Sort_Update()
    {
        //sort block
        Collections.sort(fArrayList, new AySortByRoll());
        myayAdapter.notifyDataSetChanged();
        if (AySortByRoll.getModeNumberSort()==1)
            Toast.makeText(getContext(), "Sorted from High To Low", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(getContext(), "Sorted from Low To High", Toast.LENGTH_SHORT).show();
    }


    public static void  setRefreshingFalse(){
        mWaveSwipeRefreshLayout.setRefreshing(false); //for refresh tool
    }

    //for Insert array in SQL
    public static void InsertArrayListIntoSQL(){
        aySQLdb = new AySQLdb(getContext());
        aySQLdb.Iscreated=true;
        aySQLdb.InsertArray(fArrayList);
        fArrayList= aySQLdb.GetData();

        //create and set the adapter
        myayAdapter =new ayAdapter(getContext(),fArrayList);
        ayListView.setAdapter(myayAdapter);
        ayLastUpdate.setText("Update : " +  getLastApdate());

    }

    //for load Array list from SQL
    public static void Load_Array_List_From_SQL(int id){

        aySQLdb = new AySQLdb(getContext());
        if (id!=-1){
            //create and set the adapter
            fArrayList= aySQLdb.GetData();
            myayAdapter =new ayAdapter(getContext(),fArrayList);
            ayListView.setAdapter(myayAdapter);
            ayLastUpdate.setText("Update : " +  getLastApdate());
        }
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
