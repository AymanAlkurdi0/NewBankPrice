package com.example.egypt2.banksprice;

import android.app.Fragment;
import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NotificationCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.egypt2.banksprice.myClass.AyFragment_cur_activity;
import com.example.egypt2.banksprice.myClass.AyINFO_Drawer_layout;
import com.example.egypt2.banksprice.myClass.AyNotification;
import com.example.egypt2.banksprice.myClass.AyPop;
import com.example.egypt2.banksprice.myClass.AyProgressDialog;
import com.example.egypt2.banksprice.myClass.AySharedPreferences;
import com.example.egypt2.banksprice.myClass.AyUiCuSelected;
import com.example.egypt2.banksprice.myClass.DrawerListAdapter;
import com.example.egypt2.banksprice.myClass.ayAsyncTask;
import com.example.egypt2.banksprice.myClass.ayJobSchedule;
import com.example.egypt2.banksprice.myClass.ayUI;

import java.util.ArrayList;

import jp.co.recruit_lifestyle.android.widget.WaveSwipeRefreshLayout;

public class MainActivity extends AppCompatActivity {
    AyPop ayPop;
    android.app.FragmentManager manager = getFragmentManager();
    TextView ayLastUpdate,Curency_name;
    ListView ayListView;
    ImageView Curency_image;
    RelativeLayout RelativeLayout_DrawerLayout;
    DrawerLayout DrawerLayout;
    WaveSwipeRefreshLayout mWaveSwipeRefreshLayout;
    SharedPreferences sharedPreferences;
    String URL ="http://aymanalkurdi002-001-site1.gtempurl.com/Price.asmx/Get_value_by_JSON";
    int JobNumber =123;
    LinearLayout header_linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //**************************************************************
//menu_header_custom
        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setDisplayShowHomeEnabled(false);
        mActionBar.setDisplayShowTitleEnabled(false);
        LayoutInflater li = LayoutInflater.from(this);
        View customView = li.inflate(R.layout.header_menu, null);
        mActionBar.setCustomView(customView);
        mActionBar.setDisplayShowCustomEnabled(true);

        ImageButton menu_header_open_menu = (ImageButton)    customView.findViewById(R.id.menu_header_open_menu);
        menu_header_open_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // ...
            }
        });

        ImageButton menu_header_currency_exchange = (ImageButton) customView.findViewById(R.id.menu_header_currency_exchange);
        menu_header_currency_exchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ayPop = new AyPop();
                ayPop.show(manager,null);
            }
        });
        ImageButton menu_header_photo_camera = (ImageButton) customView.findViewById(R.id.menu_header_photo_camera);
        menu_header_photo_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // ...
            }
        });

        //**************************************************************

        ayLastUpdate = (TextView) findViewById(R.id.ayLastUpdate);
        ayListView = (ListView) findViewById(R.id.ayListView);
        Curency_name = (TextView) findViewById(R.id.header_cruncey_name);
        Curency_image = (ImageView) findViewById(R.id.header_cruncey_image);
        mWaveSwipeRefreshLayout = (WaveSwipeRefreshLayout) findViewById(R.id.main_swipe);
        sharedPreferences = getSharedPreferences("MySetting",Context.MODE_PRIVATE);
        header_linearLayout = (LinearLayout) findViewById(R.id.header_main_cure_price) ;
        header_linearLayout.setBackground(getResources().getDrawable(R.drawable.header_layout,null));
        //***********************************************
        //Header of list view Price
   /*     LayoutInflater layoutInflater = LayoutInflater.from(this);
        View view = layoutInflater.inflate(R.layout.header_of_list_view_price,null);
        ayListView.addHeaderView(view);
        Curency_name = (TextView) view.findViewById(R.id.header_cruncey_name);
        Curency_image = (ImageView) view.findViewById(R.id.header_cruncey_image);*/
//************************************************************************
//set the SharedPreferences to AySharedPreferences.class
        AySharedPreferences.sharedPreferences=sharedPreferences;

        //Set the attribute for UI class
        ayUI.setContext(this);ayUI.setAyListView(ayListView); ayUI.setAyLastUpdate(ayLastUpdate);ayUI.mWaveSwipeRefreshLayout=mWaveSwipeRefreshLayout;
        AyUiCuSelected.setCurency_name(Curency_name); AyUiCuSelected.setCurency_image(Curency_image);
        //Set the attribute for AyProgressDialog class
        AyProgressDialog.context=this;

//***********************************************************************************
        //refresh tools
        mWaveSwipeRefreshLayout.setOnRefreshListener(new WaveSwipeRefreshLayout.OnRefreshListener() {
            @Override public void onRefresh() {
                //send the BroadCast
                Intent i = new Intent();
                i.setAction("android.intent.data.complete");
                sendBroadcast(i);
            }
        });
//*********************************************************************
       //************************************************************************************************************************************************************************
        //set drawer tools
        //conecet with UI

         DrawerLayout = (DrawerLayout)findViewById(R.id.DrawerLayout);//create this for cancel the next :)
        RelativeLayout_DrawerLayout =(RelativeLayout)findViewById(R.id.RelativeLayout_DrawerLayout); //to be able to cancel it

        //set the listView for the ListView in RelativeLayout_DrawerLayout
        ListView ListView_Drawer_Layout=(ListView)findViewById(R.id.ListView_Drawer_Layout);
        //create a AyINFO_Drawer_layout and put on ArrayList
        AyINFO_Drawer_layout drawerListAdapter =new AyINFO_Drawer_layout("Currency",R.drawable.currency); // set what you want for being showing in Drawer list (link for new page)
        ArrayList<AyINFO_Drawer_layout> myArray = new ArrayList<AyINFO_Drawer_layout>();
        myArray.add(drawerListAdapter);
        //pass and create the adapter and ArrayList to class
        DrawerListAdapter drawerListAdapter1 = new DrawerListAdapter(this,myArray);
        //set the adapter to listView
        ListView_Drawer_Layout.setAdapter(drawerListAdapter1);


        //when clicked on item
        ListView_Drawer_Layout.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //call the function in main activity
                selectItemFromDrawer(position);

            }
        });







        //************************************************************************************************************************************************
        // two Solution


         int ID=  AySharedPreferences.load(); //to load the old ID or last ID and passing to AyUiCuSelected.class
            try {

                AyUiCuSelected ayUiCuSelected = new AyUiCuSelected(ID);
                ayUiCuSelected.updateCruncy();


            }catch (Exception e)
            {

            }

/*
        //.........................................................................

        //crate JobScheduler
        JobInfo.Builder builder = new JobInfo.Builder(JobNumber,new ComponentName(this,ayJobSchedule.class));

        builder.setMinimumLatency(1000);

        JobScheduler jobScheduler = (JobScheduler) getSystemService(Context.JOB_SCHEDULER_SERVICE);

        jobScheduler.schedule(builder.build());






*/









    }




    //function for when select item from drawer_layout
    private void selectItemFromDrawer(int position) {
        //set the Fragment to my AyFragment_cur_activity
        Fragment fragment = new AyFragment_cur_activity();
        //replace the main_relative_layout by my fragment
        getFragmentManager().beginTransaction()
                .replace(R.id.main_relative_layout, fragment)
                .commit();
//to close RelativeLayout
        DrawerLayout.closeDrawer(RelativeLayout_DrawerLayout);
    }

    /*
//Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main2_drawer,menu);

        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()){
            case R.id.nav_change:
                //Pop Activity
                 ayPop = new AyPop();
                ayPop.show(manager,null);

                break;
            case  R.id.nav_curency:

                //Pop Activity
                 ayPop = new AyPop();
                ayPop.show(manager,null);

                break;
            case  R.id.nav_pic:
                //todo:take a pic for the price

                break;
            case  R.id.nav_setting:
                //todo:open setting page


                break;
            case  R.id.nav_share:
                //todo:set the notify


                break;

        }
        return true;
    }
*/
//End Menu Code
    //method to can dismissPop from any Class
    public void dismissPop(){
        ayPop.dismiss();
    }
    public void header_cruncey_image(View view) {
        //Pop Activity
        ayPop = new AyPop();
        ayPop.show(manager,null);

    }

    public void header_cruncey_sort_button(View view) {


        ayUI.Sort_Update();
    }






}
