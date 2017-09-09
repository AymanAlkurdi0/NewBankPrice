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
    TypedArray arrayList_Curency_image = context.getResources().obtainTypedArray(R.array.currency_Pic); ;

     AyUiCuSelected(int id) {
        this.id = id;
    }

    public void updateCruncy() {
// get resource ID by index
        Curency_name.setText(arrayList_Curency_name[id]);

        Curency_image.setImageResource(arrayList_Curency_image.getResourceId(id, -1));



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
