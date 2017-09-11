package com.example.egypt2.banksprice.myClass;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import static com.example.egypt2.banksprice.myClass.ayConverter.convertStreamToString;


/**
 * Created by egypt2 on 8/27/2017.
 */

public class ayAsyncTask extends AsyncTask<String, Integer, String>  {
    static boolean isDataComplete =false;
String JsonString ="";
    String LastApdate ="";
    AyProgressDialog ayProgressDialog = new AyProgressDialog();
    //create ArrayList to put all the object
    ArrayList<ayINFO> arrayList ;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        //ProgressDialog
        ayProgressDialog.create();
        ayProgressDialog.show();
        //display process bar
        //create ArrayList to put all the object
        arrayList =new ArrayList<ayINFO>();
        ayINFO myinfo = new ayINFO();
        myinfo.setType(0);
        arrayList.add(myinfo);
        ayUI.setfArrayList(arrayList);
        ayUI.setLastApdate("witting");
        ayUI.update();

    }

    @Override
    protected String doInBackground(String... params) {


        try {
            //create a URL connection
            URL url = new URL(params[0]);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            JsonString=convertStreamToString(in);
            in.close();

            return JsonString; //return the result and see you in onPostExecute() :)


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;


    }





    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);





        try {
//convert the string to a JSON object
            JSONObject jsonObject = new JSONObject(s);
//get all array which in JSON object and convert to JSON array
            JSONArray jsonArray =jsonObject.getJSONArray("info");
            //create ArrayList to put all the object
            arrayList =new ArrayList<ayINFO>();
//take one by one the objects form JSON array
            for(int n = 0; n < jsonArray.length(); n++)
            {

//take JSON object n form JSON array
                jsonObject = jsonArray.getJSONObject(n);
//put all the value in new node
                ayINFO myinfo =new ayINFO();
                myinfo.setBank_ID(jsonObject.getInt("bank_ID"));
                myinfo.setBank_Name(jsonObject.getString("bank_Name"));
                myinfo.setCurrency_ID(jsonObject.getInt("currency_ID"));
                myinfo.setCurrency_Name(jsonObject.getString("currency_Name"));
                myinfo.setCurrency_code(jsonObject.getString("currency_code"));
                myinfo.setBuy(jsonObject.getString("buy"));
                myinfo.setSell(jsonObject.getString("sell"));
                myinfo.setLastUpdata(jsonObject.getString("LastUpdata"));
//set the last apdate
                LastApdate=myinfo.getLastUpdata();
                //set the type of it to diplay curency no process bar
                myinfo.setType(1);
//put the node into my past Array list
                arrayList.add(myinfo);

                onProgressUpdate(100/(jsonArray.length())*(n+1));



            }

            ayUI.setfArrayList(arrayList);
            ayUI.setLastApdate(LastApdate);
            ayUI.update();

            isDataComplete=true;




        } catch (JSONException e) {
            e.printStackTrace();

        }



    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);

        //ProgressDialog
        ayProgressDialog.setProgress(values[0]);
        if (Integer.compare(ayProgressDialog.getMax(),ayProgressDialog.getProgress())==1){
            ayProgressDialog.cancel();
        }


    }
}
