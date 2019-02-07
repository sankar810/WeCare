package com.example.csulb.wecare;


import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.support.v13.app.FragmentPagerAdapter;

import com.example.csulb.wecare.fragments.HeartFragment;
import com.fitbit.authentication.AuthenticationManager;
import com.fitbit.authentication.Scope;
import com.example.csulb.wecare.fragments.ActivitiesFragment;
import com.example.csulb.wecare.fragments.DeviceFragment;
import com.example.csulb.wecare.fragments.InfoFragment;
import com.example.csulb.wecare.fragments.ProfileFragment;
import com.example.csulb.wecare.fragments.WeightLogFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sanka on 4/10/2018.
 */

//userdatapageadapter class for adding tabs in userdatapage
public class UserDataPagerAdapter extends FragmentPagerAdapter{

    private final List<InfoFragment> fragments = new ArrayList<>();

    //method for adding tabs
    public UserDataPagerAdapter(FragmentManager fm) {
        super(fm);

        fragments.clear();
        if (containsScope(Scope.activity)) {
            fragments.add(new ActivitiesFragment());
        }
        if (containsScope(Scope.profile)) {
            fragments.add(new ProfileFragment());
        }
        if (containsScope(Scope.settings)) {
            fragments.add(new DeviceFragment());
        }
    }

    //get the scopes of each fragment
    private boolean containsScope(Scope scope) {
        return AuthenticationManager.getCurrentAccessToken().getScopes().contains(scope);
    }

    //get the position of each fragment
    @Override
    public Fragment getItem(int position) {
        if (position >= fragments.size()) {
            return null;
        }

        return fragments.get(position);
    }

    ////get count of the class
    @Override
    public int getCount() {
        return fragments.size();
    }

    //get resourceid of each fragment
    public int getTitleResourceId(int index) {
        return fragments.get(index).getTitleResourceId();
    }
}
