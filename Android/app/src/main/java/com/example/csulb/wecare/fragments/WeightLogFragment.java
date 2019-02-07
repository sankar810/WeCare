package com.example.csulb.wecare.fragments;


import android.content.Loader;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fitbit.api.loaders.ResourceLoaderResult;
import com.fitbit.api.models.Weight;
import com.fitbit.api.models.WeightLogs;
import com.fitbit.api.services.WeightService;
import com.example.csulb.wecare.R;
import com.jjoe64.graphview.helper.DateAsXAxisLabelFormatter;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.Calendar;
import java.util.List;

/**
 * Created by sanka on 4/15/2018.
 */

//Weightlog fragment for weights
public class WeightLogFragment extends InfoFragment<WeightLogs> {

    //set webview uring oncreateview
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = super.onCreateView(inflater, container, savedInstanceState);
        binding.webview.setVisibility(View.GONE);
        binding.graph.setVisibility(View.VISIBLE);

        return v;
    }

    //get resource id for this class
    @Override
    public int getTitleResourceId() {
        return R.string.weight;
    }

    //get loader id for this class
    @Override
    protected int getLoaderId() {
        return 4;
    }

    //resource loader for weightfragemnt class
    @Override
    public Loader<ResourceLoaderResult<WeightLogs>> onCreateLoader(int id, Bundle args) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        return WeightService.getWeightLogLoader(getActivity(), calendar.getTime(), Calendar.MONTH, 1);
    }

    //onLoadFinished menthod for loading on finished
    @Override
    public void onLoadFinished(Loader<ResourceLoaderResult<WeightLogs>> loader, ResourceLoaderResult<WeightLogs> data) {
        super.onLoadFinished(loader, data);
        if (data.isSuccessful()) {
            bindWeightLogs(data.getResult());
        }
    }

    //print keys of weightframent class
    public void bindWeightLogs(WeightLogs weightLogs) {
        List<Weight> weights = weightLogs.getWeight();
        DataPoint[] dataPoints = new DataPoint[weights.size()];

        for (int i = 0; i < weights.size(); i++) {
            Weight weight = weights.get(i);
            dataPoints[i] = new DataPoint(weight.getDateTime(), weight.getWeight());
        }

        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(dataPoints);
        binding.graph.addSeries(series);

        binding.graph.getGridLabelRenderer().setLabelFormatter(new DateAsXAxisLabelFormatter(getActivity()));
        binding.graph.getGridLabelRenderer().setNumHorizontalLabels(3);

        binding.graph.getViewport().setMinX(dataPoints[0].getX());
        binding.graph.getViewport().setMaxX(dataPoints[dataPoints.length - 1].getX());
        binding.graph.getViewport().setXAxisBoundsManual(true);

        binding.graph.getGridLabelRenderer().setHumanRounding(false);

    }
}
