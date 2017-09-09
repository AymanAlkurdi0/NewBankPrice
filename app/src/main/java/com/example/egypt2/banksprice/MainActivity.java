package com.example.egypt2.banksprice;

import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.egypt2.banksprice.myClass.AyNotification;
import com.example.egypt2.banksprice.myClass.AyPop;
import com.example.egypt2.banksprice.myClass.AyProgressDialog;
import com.example.egypt2.banksprice.myClass.AyUiCuSelected;
import com.example.egypt2.banksprice.myClass.ayAsyncTask;
import com.example.egypt2.banksprice.myClass.ayJobSchedule;
import com.example.egypt2.banksprice.myClass.ayUI;

public class MainActivity extends AppCompatActivity {
    TextView ayLastUpdate,Curency_name;
    ListView ayListView;
    ImageView Curency_image;
    String URL ="http://aymanalkurdi002-001-site1.gtempurl.com/Price.asmx/Get_value_by_JSON";
    int JobNumber =123;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ayLastUpdate = (TextView) findViewById(R.id.ayLastUpdate);
        ayListView = (ListView) findViewById(R.id.ayListView);
        Curency_name = (TextView) findViewById(R.id.Curency_name);
        Curency_image = (ImageView) findViewById(R.id.Curency_image);
//************************************************************************


        //Set the attribute for UI class
        ayUI.setContext(this);ayUI.setAyListView(ayListView); ayUI.setAyLastUpdate(ayLastUpdate);
        AyUiCuSelected.setCurency_name(Curency_name); AyUiCuSelected.setCurency_image(Curency_image);
        //Set the attribute for AyProgressDialog class
        AyProgressDialog.context=this;
       //....................................................................................










        //.........................................................................two Solution

/*
        //send the BroadCast
        Intent i = new Intent();
        i.setAction("android.intent.data.complete");
        i.putExtra("URL",URL);
        sendBroadcast(i);

*/
        //.........................................................................

        //crate JobScheduler
        JobInfo.Builder builder = new JobInfo.Builder(JobNumber,new ComponentName(this,ayJobSchedule.class));

        builder.setMinimumLatency(1000);

        JobScheduler jobScheduler = (JobScheduler) getSystemService(Context.JOB_SCHEDULER_SERVICE);

        jobScheduler.schedule(builder.build());
















    }
//Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main2_drawer,menu);

        return true;
    }
    AyPop ayPop;
    //method to can dismissPop from any Class
    public void dismissPop(){
    ayPop.dismiss();
}
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        android.app.FragmentManager manager = getFragmentManager();

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


//End Menu Code


}
