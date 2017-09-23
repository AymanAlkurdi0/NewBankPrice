package com.example.egypt2.banksprice.myClass;

import java.util.Comparator;

/**
 * Created by zero on 9/24/2017.
 * Comparator for sort the list
 */

public class AySortByRoll implements Comparator<ayINFO> {

    @Override
    public int compare(ayINFO o1, ayINFO o2) {


        return Float.compare(Float.valueOf(o1.getBuy()), Float.valueOf(o2.getBuy()));
    }
}
