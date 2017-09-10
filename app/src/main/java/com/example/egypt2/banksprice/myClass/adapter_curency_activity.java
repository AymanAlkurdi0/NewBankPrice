package com.example.egypt2.banksprice.myClass;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.egypt2.banksprice.R;

/**
 * Created by zero on 9/11/2017.
 */

public class adapter_curency_activity extends ArrayAdapter {


    String[] array_currency_Name = getContext().getResources().getStringArray(R.array.currency_Name);
    TypedArray arrayList_Curency_image = getContext().getResources().obtainTypedArray(R.array.currency_Pic);



    public adapter_curency_activity(@NonNull Context context, String[] array_currency_Name) {
        super(context, R.layout.ay_list_pop,array_currency_Name);
    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View view = layoutInflater.inflate(R.layout.ay_list_pop,parent,false);
        //connect with UI
        TextView textView =(TextView)view.findViewById(R.id.ayNameBackPop);
        ImageView Curency_image_pop = (ImageView) view.findViewById(R.id.Curency_image_pop);
        LinearLayout ayLinearPop = (LinearLayout)view.findViewById(R.id.ayLinearPop);
        //set the UI
        String name =(String) getItem(position);
        textView.setText(name);
        Curency_image_pop.setImageResource(arrayList_Curency_image.getResourceId(position, -1));


        return view;
    }
}
