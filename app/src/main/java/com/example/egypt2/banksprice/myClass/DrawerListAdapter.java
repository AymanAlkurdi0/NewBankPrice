package com.example.egypt2.banksprice.myClass;

import android.app.Fragment;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.egypt2.banksprice.R;

import java.util.ArrayList;

/**
 * Created by zero on 9/10/2017.
 */

public class DrawerListAdapter extends ArrayAdapter {


    public DrawerListAdapter(@NonNull Context context, ArrayList<AyINFO_Drawer_layout> ayINFOs) {
        super(context, R.layout.listview_drawer_layout_item, ayINFOs);
    }


    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View view = layoutInflater.inflate(R.layout.listview_drawer_layout_item, parent, false);

        ImageView imageView_item_Drawer_Layout = (ImageView) view.findViewById(R.id.imageView_item_Drawer_Layout);
        TextView textView_item_Drawer_Layout = (TextView) view.findViewById(R.id.textView_item_Drawer_Layout);

        AyINFO_Drawer_layout info = (AyINFO_Drawer_layout) getItem(position);

        textView_item_Drawer_Layout.setText(info.name);
        imageView_item_Drawer_Layout.setImageResource(info.icon);

        return view;
    }

}