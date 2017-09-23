package com.example.egypt2.banksprice.myClass;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.List;

/**
 * Created by egypt2 on 8/31/2017.
 */

public class ayJobSchedule extends JobService {
    String URL ="http://aymanalkurdi002-001-site1.gtempurl.com/Price.asmx/Get_value_by_JSON";
    //Get_value_by_JSON_fixed?currency_ID=21

    @Override
    public boolean onStartJob(JobParameters params) {

try {

    AyUiCuSelected ayUiCuSelected = new AyUiCuSelected(0);
    ayUiCuSelected.updateCruncy();


}catch (Exception e)
{

}


        jobFinished(params,ayAsyncTask.isDataComplete);

        return !ayAsyncTask.isDataComplete;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return false;
    }
}
