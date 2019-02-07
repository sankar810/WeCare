package com.example.csulb.wecare.fragments;


import android.content.Loader;
import android.os.Bundle;

import com.fitbit.api.loaders.ResourceLoaderResult;
import com.fitbit.api.models.User;
import com.fitbit.api.models.UserContainer;
import com.fitbit.api.services.UserService;
import com.example.csulb.wecare.R;

/**
 * Created by sanka on 4/10/2018.
 */

//Profile frament class for user
public class ProfileFragment extends InfoFragment<UserContainer> {

    //get resource id for this class
    @Override
    public int getTitleResourceId() {
        return R.string.user_info;
    }

    //get  loader id for this class
    @Override
    protected int getLoaderId() {
        return 1;
    }

    //resource loader for ProfileFragment class
    @Override
    public Loader<ResourceLoaderResult<UserContainer>> onCreateLoader(int id, Bundle args) {
        return UserService.getLoggedInUserLoader(getActivity());
    }

    //onLoadFinished method for profilefragment class
    @Override
    public void onLoadFinished(Loader<ResourceLoaderResult<UserContainer>> loader, ResourceLoaderResult<UserContainer> data) {
        super.onLoadFinished(loader, data);
        if (data.isSuccessful()) {
            bindProfileInfo(data.getResult().getUser());
        }
    }

    //print keys for profie fragment
    public void bindProfileInfo(User user) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<center><h3>CONNECTED USERS</h3></center>");
        stringBuilder.append("<br>");
        printKeys(stringBuilder, user);
        setMainText(stringBuilder.toString());
    }


}
