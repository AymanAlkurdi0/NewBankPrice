package com.example.egypt2.banksprice.myClass;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.egypt2.banksprice.R;

import java.util.ArrayList;

/**
 * Created by egypt2 on 8/29/2017.
 */

//create the adapter for the pop ListView

public class ayAdapterPop extends ArrayAdapter {
    public ayAdapterPop(@NonNull Context context, @NonNull String [] ArrayList) {
        super(context, R.layout.ay_list_pop, ArrayList);
    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View view = layoutInflater.inflate(R.layout.ay_list_pop,parent,false);

        TextView textView =(TextView)view.findViewById(R.id.ayNameBackPop);
        LinearLayout ayLinearPop = (LinearLayout)view.findViewById(R.id.ayLinearPop);

        String name = (String) getItem(position);

        textView.setText(name);
        //change the color
/*
        if(position%2==0){
            ayLinearPop.setBackground(getContext().getResources().getDrawable(R.drawable.ay_item2,null));
        }else {
            ayLinearPop.setBackground(getContext().getResources().getDrawable(R.drawable.ay_item1,null));
        }

*/

        return view;
    }
}
