package com.example.csulb.wecare.fragments;


import android.content.Loader;
import android.os.Bundle;

import com.fitbit.api.loaders.ResourceLoaderResult;
import com.fitbit.api.models.Device;
import com.fitbit.api.services.DeviceService;
import com.example.csulb.wecare.R;

/**
 * Created by sanka on 4/10/2018.
 */


//DeviceFragemnt activity class
public class DeviceFragment extends InfoFragment<Device[]> {

    //get resourceid of this class
    @Override
    public int getTitleResourceId() {
        return R.string.devices;
    }

    //get loader id of this class
    @Override
    protected int getLoaderId() {
        return 2;
    }

    //Resource loader for deviceframent class
    @Override
    public Loader<ResourceLoaderResult<Device[]>> onCreateLoader(int id, Bundle args) {
        return DeviceService.getUserDevicesLoader(getActivity());
    }

    //onLoadfinished method of this class
    @Override
    public void onLoadFinished(Loader<ResourceLoaderResult<Device[]>> loader, ResourceLoaderResult<Device[]> data) {
        super.onLoadFinished(loader, data);
        if (data.isSuccessful()) {
            bindDevices(data.getResult());
        }
    }

    //print keys of device
    public void bindDevices(Device[] devices) {
        StringBuilder stringBuilder = new StringBuilder();

        for (Device device : devices) {
            stringBuilder.append("<center><h3>CONNECTED DEVICES</h3></center>");
            stringBuilder.append("<p></p>");
            stringBuilder.append("<p>"+device.getDeviceVersion().toUpperCase());
            stringBuilder.append("&trade;</b><br>");

            stringBuilder.append("<b>&nbsp;&nbsp;Type: </b>");
            stringBuilder.append(device.getType().toLowerCase());
            stringBuilder.append("<br>");

            stringBuilder.append("<b>&nbsp;&nbsp;Last Sync: </b>");
            stringBuilder.append(device.getLastSyncTime());
            stringBuilder.append("<br>");

            stringBuilder.append("<b>&nbsp;&nbsp;Battery Level: </b>");
            stringBuilder.append(device.getBattery());
            stringBuilder.append("<br><br>");
        }

        if (stringBuilder.length() > 0) {
            stringBuilder.replace(stringBuilder.length() - 8, stringBuilder.length(), "");
        }

        setMainText(stringBuilder.toString());
    }

}
