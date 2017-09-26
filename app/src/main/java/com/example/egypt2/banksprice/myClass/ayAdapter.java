package com.example.egypt2.banksprice.myClass;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.egypt2.banksprice.R;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by egypt2 on 8/27/2017.
 */

public class ayAdapter extends ArrayAdapter{


    public ayAdapter(@NonNull Context context, ArrayList<ayINFO> ayINFOs) {
        super(context, R.layout.ay_iitems, ayINFOs);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        TypedArray arrayList_Bank_image = getContext().getResources().obtainTypedArray(R.array.Banks_Pic); ; // get image R


        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        ayINFO info = (ayINFO) getItem(position);
        //two way to return the view if type 0 will display ay_loading_process layout which is the process bar otherwise display the ay_iitems layout for the price
        if (info.getType()==0){ //display the process bar

            View view = layoutInflater.inflate(R.layout.ay_loading_process,parent,false);
            return view;
        }
        else{ //display the currency

            View view = layoutInflater.inflate(R.layout.ay_iitems,parent,false);

            ImageView ayBankImage=(ImageView) view.findViewById(R.id.ayBankImage);
            TextView ayBankName =(TextView) view.findViewById(R.id.ayBankName);
            TextView ayBankBuyPrice =(TextView) view.findViewById(R.id.ayBankBuyPrice);
            TextView ayBankSellPrice =(TextView) view.findViewById(R.id.ayBankSellPrice);
            LinearLayout linearLayout =(LinearLayout) view.findViewById(R.id.ayLinear);


            //*******************************************************
            ayBankImage.setImageResource(arrayList_Bank_image.getResourceId(info.getBank_ID()-1 , 15)); // set image for banks from arrayList_Bank_image Resources
            ayBankName.setText(info.getBank_Name());
            ayBankBuyPrice.setText(String.format("%.3f",Float.valueOf( info.getBuy()))); //convert the price to 3 numbers after point .###
            ayBankSellPrice.setText(String.format("%.3f",Float.valueOf(info.getSell())));




            //for change the color beteen the items in listView
        /*
        if(position%2==0){
            linearLayout.setBackground(getContext().getResources().getDrawable(R.drawable.ay_item2,null));
        }else {
            linearLayout.setBackground(getContext().getResources().getDrawable(R.drawable.ay_item1,null));
        }
*/
            return view;
        }


    }

}
