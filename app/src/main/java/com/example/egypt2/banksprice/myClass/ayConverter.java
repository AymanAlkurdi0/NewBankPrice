package com.example.egypt2.banksprice.myClass;

/**
 * Created by egypt2 on 8/27/2017.
 */

public class ayConverter {
    //convert Stream to String
    static String convertStreamToString(java.io.InputStream is) {
        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }
}
