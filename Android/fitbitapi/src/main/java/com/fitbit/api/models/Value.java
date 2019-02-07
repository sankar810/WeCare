package com.fitbit.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by sanka on 5/9/2018.
 */

//value class for heartbeat
public class Value {
    @SerializedName("restingHeartRate")
    @Expose
    private Integer restingHeartRate;

    /**
     * @return The activeScore
     */
    public Integer getrestingHeartRate() {
        return restingHeartRate;
    }

    /**
     * @param restingHeartRate The restingHeartRate
     */
    public void setrestingHeartRate(Integer restingHeartRate) {
        this.restingHeartRate = restingHeartRate;
    }
}
