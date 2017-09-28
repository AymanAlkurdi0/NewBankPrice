package com.example.egypt2.banksprice.myClass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by zero on 9/24/2017.
 * Comparator for sort the list
 *
 *
 *
 */



public class AySortByRoll implements Comparator<ayINFO> {
    public static void setModeNumberTarget(int modeNumberTarget) {
        MODE_NUMBER_TARGET = modeNumberTarget;
    }

    public static void setModeNumberSort(int modeNumberSort) {
        MODE_NUMBER_SORT = modeNumberSort;
    }

    /**
     * please node this class for sort the array of ayINFO object so you should pass array list in the same type
     * and make sure the MODE_NUMBER which selected the mode of sorting
     *
     */

    public static int getModeNumberTarget() {
        return MODE_NUMBER_TARGET;

    }

    public static int getModeNumberSort() {
        return MODE_NUMBER_SORT;
    }

    /**
     * MODE_NUMBER:
     * High to Low               0
     * Low to High               1
     * Buy                       0

     * Sell                      1
     */
    public static int MODE_NUMBER_TARGET = 0 ;
    public static int MODE_NUMBER_SORT = 0 ;
    @Override
    public int compare(ayINFO o1, ayINFO o2) {

        switch (MODE_NUMBER_TARGET) {

            case 0:{


                switch (MODE_NUMBER_SORT) {

                    case 0: {
                        return Float.compare(
                                Float.valueOf(o1.getBuy()),
                                Float.valueOf(o2.getBuy())

                        );
                    }

                    case 1: {

                        return Float.compare(
                                Float.valueOf(o2.getBuy()),
                                Float.valueOf(o1.getBuy())
                        );

                    }


                    }



            }
            case 1: {

                switch (MODE_NUMBER_SORT) {

                    case 0: {
                        return Float.compare(
                                Float.valueOf(o1.getSell()),
                                Float.valueOf(o2.getSell())

                        );
                    }

                    case 1: {

                        return Float.compare(
                                Float.valueOf(o2.getSell()),
                                Float.valueOf(o1.getSell())
                        );

                    }


                }

            }

            default:{
                return Float.compare(
                        Float.valueOf(o1.getBuy()),
                        Float.valueOf(o2.getBuy())

                );

            }


        }

    }






}