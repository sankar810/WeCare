package com.example.csulb.wecare.fragments;


import android.content.Loader;
import android.os.Bundle;

import com.fitbit.api.loaders.ResourceLoaderResult;
import com.fitbit.api.models.DailyActivitySummary;
import com.fitbit.api.models.Goals;
import com.fitbit.api.models.Summary;
import com.fitbit.api.services.ActivityService;
import com.example.csulb.wecare.R;

import java.util.Date;

/**
 * Created by sanka on 4/10/2018.
 */

//Activity tab fragment
public class ActivitiesFragment extends InfoFragment<DailyActivitySummary> {

    //gets resource id of this page
    @Override
    public int getTitleResourceId() {
        return R.string.activity_info;
    }

    //get lodaer id
    @Override
    protected int getLoaderId() {
        return 3;
    }

    //resourceloader for activity fragment
    @Override
    public Loader<ResourceLoaderResult<DailyActivitySummary>> onCreateLoader(int id, Bundle args) {
        return ActivityService.getDailyActivitySummaryLoader(getActivity(), new Date());
    }

    //onLoadFinished for activity fragemtn
    @Override
    public void onLoadFinished(Loader<ResourceLoaderResult<DailyActivitySummary>> loader, ResourceLoaderResult<DailyActivitySummary> data) {
        super.onLoadFinished(loader, data);
        if (data.isSuccessful()) {
            bindActivityData(data.getResult());
        }
    }

    //prints the strings of activity page
    public void bindActivityData(DailyActivitySummary dailyActivitySummary) {
        StringBuilder stringBuilder = new StringBuilder();

        Summary summary = dailyActivitySummary.getSummary();
        Goals goals = dailyActivitySummary.getGoals();

        stringBuilder.append("<center><h3>TODAY</h3></center>");
        stringBuilder.append("<br/>");
        printKeys(stringBuilder, summary);

        stringBuilder.append("<br /><br />");
        stringBuilder.append("<center><h3>GOAL</h3></center>");
        stringBuilder.append("<br />");
        printKeys(stringBuilder, goals);

        setMainText(stringBuilder.toString());
    }
}
