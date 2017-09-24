package com.example.egypt2.banksprice.myClass;

import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.egypt2.banksprice.MainActivity;
import com.example.egypt2.banksprice.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by zero on 9/9/2017.
 */

public class AyUiCuSelected extends ayUI {


    static TextView Curency_name;
    static ImageView Curency_image;

    int id;

    String[] arrayList_Curency_name = context.getResources().getStringArray(R.array.currency_Name); ;
    int[] arrayList_Curency_id = context.getResources().getIntArray(R.array.Currency_ID); ;
    TypedArray arrayList_Curency_image = context.getResources().obtainTypedArray(R.array.currency_Pic); ;

     AyUiCuSelected(int id) {
        this.id = id;

         AySharedPreferences.save(id); // to save the ID which represent to the selected Curency
    }

    public void updateCruncy() {

        String URL ="http://aymanalkurdi002-001-site1.gtempurl.com/Price.asmx/Get_value_by_JSON_fixed?currency_ID="+arrayList_Curency_id[id];
        //http://aymanalkurdi002-001-site1.gtempurl.com/Price.asmx/Get_value_by_JSON_fixed?currency_ID=2
        try {

            ayAsyncTask task = new ayAsyncTask();
            task.execute(URL);
            // get resource ID by index
            Curency_name.setText(arrayList_Curency_name[id]);

            Curency_image.setImageResource(arrayList_Curency_image.getResourceId(id, -1));

        }catch (Exception e)
        {

        }

        //call method from MainActivity to dismissPop
        MainActivity mainActivity = (MainActivity)context;
        mainActivity.dismissPop();

    }









    public static void setCurency_name(TextView curency_name) {
        Curency_name = curency_name;
    }

    public static void setCurency_image(ImageView curency_image) {
        Curency_image = curency_image;
    }

    public void setId(int id) {
        this.id = id;
    }






}
