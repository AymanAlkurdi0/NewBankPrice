package com.example.egypt2.banksprice.myClass;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by egypt2 on 8/31/2017.
 */

public class ayBroadCast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent.getAction().equals("android.intent.data.complete"))
        {
            int ID=  AySharedPreferences.load(); //to load the old ID or last ID and passing to AyUiCuSelected.class
            try {

                AyUiCuSelected ayUiCuSelected = new AyUiCuSelected(ID);
                ayUiCuSelected.updateCruncy();


            }catch (Exception e)
            {

            }
        }


    }
}





















