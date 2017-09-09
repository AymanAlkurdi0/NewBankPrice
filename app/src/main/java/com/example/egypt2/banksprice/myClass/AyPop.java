package com.example.egypt2.banksprice.myClass;

import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.egypt2.banksprice.R;

/**
 * Created by egypt2 on 8/29/2017.
 */

//this class for connect with the pop Activity  R.layout.ay_activity_pop

public class AyPop extends DialogFragment implements View.OnClickListener {
    View view;


    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        //create the connect with layout
        view = layoutInflater.inflate(R.layout.ay_activity_pop, viewGroup, false);

        getDialog().setTitle("Select the Currency");
        //get the array form values file
        String[] array = getResources().getStringArray(R.array.currency_Name);

        //set the adapter for listView
        ayAdapterPop adapter = new ayAdapterPop(getContext(), array);
        ListView listView = (ListView) view.findViewById(R.id.ayListViewPop);
        listView.setAdapter(adapter);
        //when the item clicked in pop show
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                int i  = Integer.parseInt(String.valueOf(id));
                //create a object form AyUiCuSelected class and passing the id of the item which is clicked
                AyUiCuSelected ayUiCuSelected = new AyUiCuSelected(i);
                ayUiCuSelected.updateCruncy();




            }
        });



        return view;
    }

    //when anything Clicked in pop Activity
    @Override
    public void onClick(View v) {


    }


}
