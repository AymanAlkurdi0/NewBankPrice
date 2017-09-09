package com.example.egypt2.banksprice.myClass;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;

/**
 * Created by zero on 9/7/2017.
 */

public class AyProgressDialog extends ProgressDialog {
    public static Context context;
    public static int theme = ProgressDialog.STYLE_HORIZONTAL;
    int max = 100;
    String Title = "getting the rate" , Message="running";

    public AyProgressDialog() {
        super(context, theme );
    }

    public void create()
    {
        super.setMax(max);
        super.setTitle(Title);
        super.setMessage(Message);
        super.setIndeterminate(true);
        super.setCancelable(true);
    }



}
