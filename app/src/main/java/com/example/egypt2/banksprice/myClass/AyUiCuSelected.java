package com.example.egypt2.banksprice.myClass;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

    String[] arrayList_Curency_name = context.getResources().getStringArray(R.array.currency_Name);
    int[] arrayList_Curency_id = context.getResources().getIntArray(R.array.Currency_ID);
    TypedArray arrayList_Curency_image = context.getResources().obtainTypedArray(R.array.currency_Pic);

     public AyUiCuSelected(int id) {
        this.id = id;
    }

    public void updateCruncy() {


        //to check from internet connection by using isConnected() function
        if (isConnected()){
            try {
                // get resource ID by index
                String URL ="http://aymanalkurdi002-001-site1.gtempurl.com/Price.asmx/Get_value_by_JSON_fixed?currency_ID="+arrayList_Curency_id[id];

                ayAsyncTask task = new ayAsyncTask();
                task.execute(URL);

                AySharedPreferences.save(id);
            }catch (Exception e)
            {
                Any_Erorr();

            }
        }
        else{
            Any_Erorr();
        }
        //set the image and name of Currency
        Curency_name.setText(arrayList_Curency_name[id]);
        Curency_image.setImageResource(arrayList_Curency_image.getResourceId(id, -1));

        ayUI.setRefreshingFalse();
        //call method from MainActivity to dismissPop and setRefreshingFalse
        ((MainActivity)context).dismissPop();


    }

//to check from internet connection
    public boolean isConnected(){
        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&  activeNetwork.isConnectedOrConnecting();
        return isConnected;
    }
    private void Any_Erorr()
    {
        Toast.makeText(context, "Please check your internet connection", Toast.LENGTH_SHORT).show();
        //to load the old ID or last ID and passing to AyUiCuSelected.class
        id =   AySharedPreferences.load();
        //load data from SQL
        Load_Array_List_From_SQL(id);

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
