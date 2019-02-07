package com.example.csulb.wecare.fragments;

import android.content.Loader;
import android.os.Bundle;

import com.fitbit.api.loaders.ResourceLoaderResult;
import com.fitbit.api.models.ActivitiesHeart;
import com.fitbit.api.models.Heart;
import com.fitbit.api.services.HeartService;
import com.example.csulb.wecare.R;

import java.util.Date;

/**
 * Created by sanka on 5/3/2018.
 */

//Heart fragment class
public class HeartFragment extends InfoFragment<Heart> {

    //gets resource id of this class
    @Override
    public int getTitleResourceId() {
        return R.string.heartrate;
    }

    //get loader id of this class
    @Override
    protected int getLoaderId() {
        return 2;
    }

    //Resource loader for heart class
    @Override
    public Loader<ResourceLoaderResult<Heart>> onCreateLoader(int id, Bundle args) {
        return HeartService.getUserHeartLoader(getActivity(), new Date());
    }

    //onLoadFinished method for this class
    @Override
    public void onLoadFinished(Loader<ResourceLoaderResult<Heart>> loader, ResourceLoaderResult<Heart> data) {
        super.onLoadFinished(loader, data);
        if (data.isSuccessful()) {
            bindHeart(data.getResult());
        }
    }

    //Print keys for heartfragment
    public void bindHeart(Heart hearts) {
        StringBuilder stringBuilder = new StringBuilder();
        ActivitiesHeart activitiesheart = hearts.getActivitiesHeart();

            //stringBuilder.append("<b>HeartBeat ");
            //stringBuilder.append(hearts.getactivities_heart());
            //stringBuilder.append("&trade;</b><br>");
        stringBuilder.append("<b>TODAY</b> ");
        stringBuilder.append("<br />");
        printKeys(stringBuilder,activitiesheart);


        setMainText(stringBuilder.toString());
    }
}
