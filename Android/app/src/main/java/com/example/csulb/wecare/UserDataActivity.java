package com.example.csulb.wecare;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.fitbit.authentication.AuthenticationManager;
import com.example.csulb.wecare.databinding.ActivityUserDataBinding;

//user data actity class for displaying the tabs and keys of each tab
public class UserDataActivity extends Activity {

    private ActivityUserDataBinding binding;
    private UserDataPagerAdapter userDataPagerAdapter;

    public static Intent newIntent(Context context) {
        return new Intent(context, UserDataActivity.class);
    }

    //oncreate method for userdataactivity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_user_data);
        binding.setLoading(false);
        getActionBar().setDisplayShowHomeEnabled(false);  // hides action bar icon
        getActionBar().setDisplayShowTitleEnabled(false); // hides action bar title
        userDataPagerAdapter = new UserDataPagerAdapter(getFragmentManager());
        binding.viewPager.setAdapter(userDataPagerAdapter);

        binding.viewPager.addOnPageChangeListener(
                new ViewPager.SimpleOnPageChangeListener() {
                    @Override
                    public void onPageSelected(int position) {
                        // When swiping between pages, select the
                        // corresponding tab.
                        getActionBar().setSelectedNavigationItem(position);
                    }
                });

        addTabs();
    }

    //on back pressed navigates to homeactivity
    public void onBackPressed()
    {
        finish();
        Intent myIntent = new Intent(UserDataActivity.this, HomeActivity.class);
        myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(myIntent);
    }

    //adds tabs for each fragment in userdataactivity
    private void addTabs() {
        final ActionBar actionBar = getActionBar();
        // Specify that tabs should be displayed in the action bar.
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        int numberOfTabs = userDataPagerAdapter.getCount();
        for (int i = 0; i < numberOfTabs; i++) {
            final int index = i;
            actionBar.addTab(
                    actionBar.newTab()
                            .setText(getString(userDataPagerAdapter.getTitleResourceId(i)))
                            .setTabListener(new ActionBar.TabListener() {
                                @Override
                                public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
                                    binding.viewPager.setCurrentItem(index);
                                }

                                @Override
                                public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

                                }

                                @Override
                                public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

                                }
                            }));
        }
    }

    //on logout button click for fitbit logout
    public void onLogoutClick(View view) {
        binding.setLoading(true);
        AuthenticationManager.logout(this);
    }


}
