package com.example.egypt2.banksprice.myClass;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.egypt2.banksprice.MainActivity;
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

    //Navigation Drawer
    public static  ActionBarDrawerToggle mActionBarDrawerToggle;
    public static RelativeLayout RelativeLayout_DrawerLayout;
    public static DrawerLayout mDrawerLayout;
    public static  ListView ayListViewDrawerLayout;
    public static boolean mSlideState;


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



    public static void drawer_set(){

        //create a AyINFO_Drawer_layout and put on ArrayList
        AyINFO_Drawer_layout drawerListAdapter =new AyINFO_Drawer_layout("Currency",R.drawable.currency); // set what you want for being showing in Drawer list (link for new page)

        ArrayList<AyINFO_Drawer_layout> mArrayList = new ArrayList<AyINFO_Drawer_layout>();

        mArrayList.add(drawerListAdapter);

        //pass and create the adapter and ArrayList to class
        DrawerListAdapter drawerListAdapter1 = new DrawerListAdapter(getContext(),mArrayList);
        //set the adapter to listView
        ayListViewDrawerLayout.setAdapter(drawerListAdapter1);


        //when clicked on item
        ayListViewDrawerLayout.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //call the function in main activity
                selectItemFromDrawer(position);

            }
        });


        set_Toggle();

    }
    static void set_Toggle(){
        mActionBarDrawerToggle = new ActionBarDrawerToggle((MainActivity)context,mDrawerLayout,R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(mActionBarDrawerToggle);
        mActionBarDrawerToggle.syncState();
        ((MainActivity)context).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }



    //function for when select item from drawer_layout
    private static void selectItemFromDrawer(int position) {
        if (position==0) {
            //set the Fragment to my AyFragment_cur_activity
            Fragment fragment = new AyFragment_cur_activity();
            //replace the main_relative_layout by my fragment
            ((MainActivity) context).getFragmentManager().beginTransaction()
                    .replace(R.id.main_relative_layout, fragment)
                    .addToBackStack(null).commit();;
//to close RelativeLayout
            mDrawerLayout.closeDrawer(RelativeLayout_DrawerLayout);
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
