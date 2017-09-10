package com.example.egypt2.banksprice.myClass;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.egypt2.banksprice.R;

/**
 * Created by zero on 9/11/2017.
 */


//this class for create a new activity to be replace with main in DrawerLayout and it should be concoction with layout activity and here we have ay_currency_activity for this porpoise

public class AyFragment_cur_activity extends Fragment {
    public AyFragment_cur_activity() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        String[] array_currency_Name = getContext().getResources().getStringArray(R.array.currency_Name);
        //get the view from ay_currency_activity
        View view = inflater.inflate(R.layout.ay_currency_activity,container,false);
        //conroll in view
        ListView listView_activity = (ListView)view.findViewById(R.id.ayListView_currency_activity);
        //create and set the adapter for listView_activity which is in listView_activity
        adapter_curency_activity my_adapter_curency_activity = new adapter_curency_activity(getContext(),array_currency_Name);
        listView_activity.setAdapter(my_adapter_curency_activity);

        return view;
    }
}
